package ro.quickaffe.mech.api;

import ro.quickaffe.mech.CoffeeSpecs;
import ro.quickaffe.mech.base.ExpirableProduct;

/**
 * @author Bogdan Mocanu
 */
public class GroundCoffee extends ExpirableProduct {

    public GroundCoffee() {
        super(CoffeeSpecs.GROUND_COFFEE_VALIDITY_MS);
    }
}
