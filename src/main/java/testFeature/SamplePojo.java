package testFeature;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SamplePojo {

    String name;

    String address;

    Integer phone;

    SamplePojoSub samplePojoSub;
}
