package testFeature;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class MapSetter {
    private Object t;

    public MapSetter(){
        Map<String,Object> test = new HashMap<>();
        test.put("k1",1);
        test.put("k2","v2");
        this.t = test;
    }

}
