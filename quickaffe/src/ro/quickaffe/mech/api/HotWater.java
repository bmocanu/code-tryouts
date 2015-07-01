package ro.quickaffe.mech.api;

import ro.quickaffe.mech.CoffeeSpecs;
import ro.quickaffe.mech.base.ExpirableProduct;

/**
 * @author Bogdan Mocanu
 */
public class HotWater extends ExpirableProduct {

    public HotWater() {
        super(CoffeeSpecs.HOT_WATER_VALIDITY_MS);
    }
}
