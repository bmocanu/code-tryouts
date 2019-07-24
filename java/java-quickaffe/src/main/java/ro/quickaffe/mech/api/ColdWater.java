package ro.quickaffe.mech.api;

import ro.quickaffe.mech.CoffeeSpecs;
import ro.quickaffe.mech.base.ExpirableProduct;

/**
 * @author Bogdan Mocanu
 */
public class ColdWater extends ExpirableProduct {

    public ColdWater() {
        super(CoffeeSpecs.COLD_WATER_VALIDITY_MS);
    }
}
