package ro.quickaffe.mech.api;

import ro.quickaffe.mech.CoffeeSpecs;
import ro.quickaffe.mech.base.ExpirableProduct;

/**
 * @author Bogdan Mocanu
 */
public class CoffeeBeans extends ExpirableProduct {

    public CoffeeBeans() {
        super(CoffeeSpecs.COFFEE_BEANS_VALIDITY_MS);
    }
}
