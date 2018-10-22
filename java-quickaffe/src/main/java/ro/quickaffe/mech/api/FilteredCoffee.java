package ro.quickaffe.mech.api;

import ro.quickaffe.mech.CoffeeSpecs;
import ro.quickaffe.mech.base.ExpirableProduct;

public class FilteredCoffee extends ExpirableProduct {
    public FilteredCoffee() {
        super(CoffeeSpecs.FILTERED_COFFEE_VALIDITY_MS);
    }
}
