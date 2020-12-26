package testFeature;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class TestGson {
    public static void main(String argsp[]) {
        List<SamplePojo> samplePojos = new ArrayList<>();
        SamplePojoSub s1 = new SamplePojoSub(1);
        SamplePojoSub s2 = new SamplePojoSub(2);
        SamplePojoSub s3 = new SamplePojoSub(3);
        SamplePojo ss1 = new SamplePojo("a", "a1", 9, s1);
        SamplePojo ss2 = new SamplePojo("b", "b1", 9, s2);
        SamplePojo ss3 = new SamplePojo("c", "c1", 9, s3);
        samplePojos.add(ss1);
        samplePojos.add(ss2);
        samplePojos.add(ss3);
        Gson gson = new GsonBuilder().create();
        String op = gson.toJson(samplePojos);
        System.out.println(op);

//        MapSetter s = new MapSetter();
//        Object r = s.getT();
//        Map<String,Object> rm = (Map<String, Object>)r;
//        for(Map.Entry<String,Object> e:rm.entrySet()){
//            String key = e.getKey();
//            String val = (String) e.getValue();
//            System.out.println(key +"="+ val);
//        }

        String pstr = " 1a 2b 3c 4d 5e";
        Map<String, String> p = new HashMap<>();
        p.put("1", "p");
        p.put("2", "p");
        p.put("3", "p");
        p.put("4", "p");
        p.put("5", "p");
        String temp = pstr;
        for (Map.Entry<String, String> kp : p.entrySet()) {
            temp = temp.replaceAll(kp.getKey(), kp.getValue());
        }

        System.out.println("resullt ---> " + temp);
        TestEnum e = TestEnum.get("1");
        if (e.equals(TestEnum.Flat)) {
            System.out.println("hello there");
        }
        Long l = 1l;    
        System.out.println("hiii" + l * 1000);
        Float f = new Float(0.0);
        Integer i = Math.round(f);
        System.out.println(f.toString());
        System.out.println(i);

        if (f > 0) {
            System.out.println("float is greater");
        } else if (f == 0) {
            System.out.println("float is equl");
        } else {
            System.out.println("float is less");
        }

        Integer ii = new Integer(2);
        Long ll = Long.valueOf(ii);
        System.out.println("longgg: " + ll + " iii=" + ii);

        //another test

        Long l1 = new Long(1);
        Long l2 = null;
        if(l1.equals(l2)){
            System.out.println("long compare 1");
        }else{
            System.out.println("none compare");
        }

        List<Long> longList = new ArrayList<>(Arrays.asList(1l));
        longList.add(2l);
        for (Long t : longList) {
            System.out.println(t);
        }

        Map<Integer, SamplePojo> samplePojoMap = new HashMap<>();
        Set<Integer> tSet = samplePojos.stream().map(d->d.getPhone()).collect(Collectors.toSet());
        samplePojoMap = samplePojos.stream().collect(Collectors.toMap(d -> d.getPhone(), d -> d, (d1, d2) -> d1));
        System.out.println("op for map duplicate");
        for (Map.Entry<Integer, SamplePojo> s : samplePojoMap.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }

        for(Integer k:tSet){
            System.out.println(k);

        }
        List<List<Integer>> test = new ArrayList<>();
        test.add(getIntegerList(1));
        test.add(getIntegerList(3));
        test.add(getIntegerList(5));

        for(List<Integer> it:test){
            testnoelement(it);
            System.out.println(it);
            if(it.isEmpty()){
                System.out.println("wow");
            }
        }
        System.out.println("Guava test");
        List<List<Integer>> tea = Lists.partition(getIntegerList(1),10);
        for(List<Integer> it:tea){
            List<Integer> pi= new ArrayList<>(it);
            testnoelement(pi);
            System.out.println(pi);
            if(pi.isEmpty()){
                System.out.println("wow");
            }
        }

        UUID uuid = UUID.randomUUID();
        Map<String,String > tmap = new HashMap<>();
        tmap.put(uuid.toString(),uuid.toString());
        System.out.println(tmap.get(uuid.toString()));

        System.out.println("long equality");
        Long lo1 = new Long(4024);
        if(lo1.equals(4024l)){
            System.out.println("viola it works");
        }



    }

    private static List<Integer> getIntegerList(int i){
        List<Integer> test1 = new ArrayList<>();
        for(int p=0;p<10;p++){
            test1.add(i);
            i++;
        }
        return test1;
    }

    private static void testnoelement(List<Integer> test) {
        List<Integer> p = new ArrayList<>();
        for(int i=0;i<=10;i++){
            p.add(i);
        }
        test.removeAll(p);
    }

}
