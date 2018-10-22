package ro.quickaffe.mech.api;

import ro.quickaffe.mech.CoffeeSpecs;
import ro.quickaffe.mech.base.ExpirableProduct;

/**
 * @author Bogdan Mocanu
 */
public class MixedCoffee extends ExpirableProduct {

    public MixedCoffee() {
        super(CoffeeSpecs.MIXED_COFEE_VALIDITY_MS);
    }
}
