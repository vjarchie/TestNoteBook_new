package testFeature;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

class Holding {
    Integer totalRecords;
    Integer recordsPerPage;
    Integer page;
    String nextPage;
    DataHolding[] data;
}

class Pricing {
    Integer totalRecords;
    Integer recordsPerPage;
    Integer page;
    String nextPage;
    DataPricing[] data;
}

class DataPricing {
    String date;
    String security;
    Double price;
}

class DataHolding {
    String date;
    String security;
    Double quantity;
    String portfolio;
}

class AssetData {
    String security;
    Double price;
    Map<String,Double> portfolioQuantity = new HashMap<>();

}

public class ArcesiumCalculator {

    public static void populateHoldingData(String date, Map<String, AssetData> assetDataMap) {
        String urlString = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/paging/holding_start";
        Gson gson = new Gson();
      //  Integer page = 0;
        while (urlString != null) {
           // System.out.println("holding page" + page++);
            String output = getRestResposeString(urlString);
            Holding holding = gson.fromJson(output, Holding.class);
            if (holding != null) {
                for (int i = 0; i < holding.data.length; i++) {
                    DataHolding dataHolding = holding.data[i];
                    if (dataHolding.date.equalsIgnoreCase(date)) {
                        String key = dataHolding.security;
                        AssetData assetData = null;
                        if (assetDataMap.containsKey(key)) {
                            assetData = assetDataMap.get(key);
                        } else {
                            assetData = new AssetData();
                        }
                        Double quantity = 0d;
                        if(assetData.portfolioQuantity.containsKey(dataHolding.portfolio)){
                            quantity += assetData.portfolioQuantity.get(dataHolding.portfolio);
                        }
                        assetData.portfolioQuantity.put(dataHolding.portfolio, quantity+dataHolding.quantity);
                        assetDataMap.put(key,assetData);
                    }
                }
            }
            urlString = holding.nextPage;
        }
    }

    public static void populatePricingData(String date, Map<String, AssetData> assetDataMap) {
        String urlString = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/paging/pricing_start";
        Gson gson = new Gson();
       // Integer page = 0;
        while (urlString != null) {
           // System.out.println("pricing page" + page++);
            String output = getRestResposeString(urlString);
            Pricing holding = gson.fromJson(output, Pricing.class);
            if (holding != null) {
                for (int i = 0; i < holding.data.length; i++) {
                    DataPricing dataPricing = holding.data[i];
                    if (dataPricing.date.equalsIgnoreCase(date)) {
                        String key = dataPricing.security;
                        AssetData assetData = null;
                        if (assetDataMap.containsKey(key)) {
                            assetData = assetDataMap.get(key);
                        } else {
                            assetData = new AssetData();
                        }
                        assetData.price = dataPricing.price;
                    }
                }
            }
            urlString = holding.nextPage;
        }
    }

    public static double calculateNAV(String date) {
        Map<String,AssetData> stringAssetDataMap = new HashMap<>();
        populateHoldingData(date,stringAssetDataMap);
        populatePricingData(date,stringAssetDataMap);
        Double result = 0d;
        if(!stringAssetDataMap.isEmpty()){
            for(Map.Entry<String,AssetData> entry:stringAssetDataMap.entrySet()){
                AssetData assetData = entry.getValue();
                if(!assetData.portfolioQuantity.isEmpty()){
                    for(Map.Entry<String,Double> ientry:assetData.portfolioQuantity.entrySet()){
                      //  System.out.println(" portfolio: "+ ientry.getKey() + " quantity: "+ ientry.getValue() + " price: "+assetData.price);
                        result +=(ientry.getValue() * assetData.price);
                    }
                }
            }
        }
        return Math.round(result*100)/100;
    }


    public static String getRestResposeString(String urlString) {
        try {

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            StringBuffer output = new StringBuffer();
            String out;
            while ((out = br.readLine()) != null) {
                output.append(out);
            }

            conn.disconnect();
            return output.toString();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Double result = calculateNAV("20190103");
        System.out.println( "total holding " + result);
    }

}
