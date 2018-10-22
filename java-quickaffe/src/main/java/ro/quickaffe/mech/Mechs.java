package ro.quickaffe.mech;

import ro.quickaffe.mech.api.*;

import static ro.quickaffe.mech.CoffeeSpecs.*;
import static ro.quickaffe.mech.Utils.*;

/**
 * Collection of coffee machine mechanisms that can be commanded from the chip when preparing a coffee.
 *
 * @author Bogdan Mocanu
 * @see CoffeeSpecs for the parameters that these mechanisms are using
 */
public class Mechs {

    public static ColdWater drawWater() {
        sleep(DRAW_WATER_DURATION_MS);
        return new ColdWater();
    }

    public static HotWater heatWater(ColdWater coldWater) {
        checkExpiration(coldWater, "This water is stale!");
        sleep(HEAT_WATER_DURATION_MS);
        return new HotWater();
    }

    public static CoffeeBeans drawCoffeeBeans() {
        sleep(DRAW_COFFEE_BEANS_DURATION_MS);
        return new CoffeeBeans();
    }

    public static GroundCoffee grindCoffeeBeans(CoffeeBeans coffeeBeans) {
        checkExpiration(coffeeBeans, "These beans are gone!");
        sleep(GRIND_COFFEE_DURATION_MS);
        return new GroundCoffee();
    }

    public static MixedCoffee mixCoffeeAndWater(GroundCoffee groundCoffee, HotWater hotWater) {
        checkExpiration(groundCoffee, "This coffee powder is all wet and garbage-ready!");
        checkExpiration(hotWater, "This hot water is missing the HOT part!");
        sleep(GRIND_COFFEE_DURATION_MS);
        return new MixedCoffee();
    }

    public static FilteredCoffee filterCoffee(MixedCoffee mixedCoffee) {
        checkExpiration(mixedCoffee, "This mixed cofee is a no-go!");
        sleep(GRIND_COFFEE_DURATION_MS);
        return new FilteredCoffee();
    }

}
