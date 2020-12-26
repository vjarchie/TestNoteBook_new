package testFeature;

import java.util.HashMap;
import java.util.Map;

public enum TestEnum {

    Flat (1),
    FreeItem (3),
    FlatConditional (8),
    Voucher (16),
    Coupon (32),
    DiscountedItem (64),
    FixedPriceCombo (128),
    StaggeredCombo (256),
    EarlyBird (512),
    BuyXGetYTD (1024),
    FreeItemsTD (2048);

    private final int value;

    private static final Map<String, TestEnum> lookup = new HashMap<>();

    static {
        for (TestEnum d : TestEnum.values()) {
            lookup.put(d.value().toString(), d);
        }
    }

    private TestEnum(int value) {
        this.value = value;
    }

    public Integer value() { return this.value; }

    public String toString() {
        return this.name();
    }

    public static TestEnum get(String value) {
        return lookup.get(value);
    }


}
