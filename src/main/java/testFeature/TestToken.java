package testFeature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

public class TestToken {

    public static void main(String[] args){
        String token = "eyJraWQiOiJOVlFZVFo2MW0wX0dhM2ozbXpFR2pyaXA3cTZyZHNGbmRxeFVTWWZSd2tRIiwiYWxnIjoiUlMyNTYifQ.eyJ2ZXIiOjEsImp0aSI6IkFULmVJX3V2dkJiTXJlV25UTXlPNWJOUWJIb05WWDdRNEs1M1Q1YVBXRGhDcUkub2FyaWRwd3NyWHJuMnY0dUcxZDYiLCJpc3MiOiJodHRwczovL2Fkb2Jlc2lnbi1zdGFnZS5va3RhcHJldmlldy5jb20vb2F1dGgyL2F1czEzbTA0MWlGTVBobGpTMWQ3IiwiYXVkIjoiYXBpOi8vYWRvYmUtc2lnbiIsImlhdCI6MTY0NTc3NzcwMSwiZXhwIjoxNjQ1Nzc4MDAxLCJjaWQiOiIwb2EyamwydTRmWjlacDFaWjFkNyIsInVpZCI6IjAwdTI3djkzZ3lqbVc0Vm1mMWQ3Iiwic2NwIjpbIm9mZmxpbmVfYWNjZXNzIiwib3BlbmlkIiwiYWNjX2ltcCJdLCJzdWIiOiJ4MSswMG8xY2d6MWplcjk2OFVGeDFkN0B0aGVtaWdyYXRpb250aHJlZS5jb20iLCJmaXJzdE5hbWUiOiJ4MSIsImxhc3ROYW1lIjoieDEiLCJlbWFpbCI6IngxQHRoZW1pZ3JhdGlvbnRocmVlLmNvbSIsInNpZ24taW1tdXRhYmxlLWlkIjoiMDBvMWNnejFqZXI5NjhVRngxZDctMDB1Mjd2YTE2aUhaRk0zcHExZDcifQ.R2rxRAS9UUkTmek3sSJfpznxqSaeSqrciQCasc8Jg76Q3dOAQ4ov-cwlZqL83XuSkzYXFjlXBkQRnskzfI_CiL3XLpWvGAInCBNCpsm_Fg3HQKzeKY86RUN9Xm9BSPStO-vCnA9nxKkGsv_dw7zNtrlE586LrUyLEk3SkGXtxwpvuoGR9BQTpa2dRc5vmiCe88OFmx6nOTbOGWF9VfTVTnFMWCqBQLEgzllHdI1-8NdcgtrC6z3Eq0LAwac7j_TYAoBAkKy_LWnXjimYmsgisJuMo6tHtdLeoiiou3573A0mXUpcmiKWBrCC9-HwrQPN3AOfERUTE_OtG-RGq7NA0Q";
        System.out.println("path = " + extractParameterValueFromToken(token,"iss"));
    }

    public static String extractParameterValueFromToken(String accessToken, String parameterKey) {
        String tokenPayload = extractBodyFromJWTToken(accessToken);
//        if(tokenPayload != null && tokenPayload.length()>0){
//            return tokenPayload;
//        }
        return extractParameterFromTokenClaims(tokenPayload, parameterKey);
    }

    private static String extractBodyFromJWTToken(String accessToken) {
        String[] parts = accessToken.split("\\.");
        if (Objects.isNull(parts) || parts.length != 3) {
            return null;
        }
        return parts[1];
    }

    private static String extractParameterFromTokenClaims(String tokePayload, String parameterKey) {
        byte[] decodedPayloadBytes = Base64.getDecoder().decode(tokePayload);
        String parameterValue = null;
        try {
            JsonNode claims = new ObjectMapper().readTree(new String(decodedPayloadBytes, StandardCharsets.UTF_8));
            JsonNode valueNode = claims.path(parameterKey);
            if(!valueNode.isArray()){
                return claims.path(parameterKey).asText();
            }
            ArrayNode arrValueNode = (ArrayNode)valueNode;
            List<String> values = new ArrayList<>();
            for (int i = 0; i < arrValueNode.size(); i++) {
                values.add(arrValueNode.get(i).asText());
            }
            return String.join(",", values);
        }
        catch (JsonProcessingException exception) {
            System.out.println("Error while parsing the token payload json: "+ exception);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parameterValue;
    }
}
