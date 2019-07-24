package ro.quickaffe.mech;

/**
 * Contains the parameters that the coffee mechanisms are using for establishing the times required for processing
 * various parts of the coffee, and the total validity times of each intermediate product.
 *
 * @author Bogdan Mocanu
 */
public class CoffeeSpecs {

    /*
     * Durations; how much time each coffee process step takes.
     */
    public static final long DRAW_WATER_DURATION_MS = 5;
    public static final long HEAT_WATER_DURATION_MS = 5;
    public static final long DRAW_COFFEE_BEANS_DURATION_MS = 5;
    public static final long GRIND_COFFEE_DURATION_MS = 5;
    public static final long COFFEE_MIXING_DURATION_MS = 5;
    public static final long COFFEE_FILTERING_DURATION_MS = 5;

    /*
     * Validity times; this dictates how much time a certain coffee intermediate product can last until it becomes
     * expired.
     */
    public static final long COLD_WATER_VALIDITY_MS = 60000;
    public static final long COFFEE_BEANS_VALIDITY_MS = 10000;
    public static final long HOT_WATER_VALIDITY_MS = 500;
    public static final long GROUND_COFFEE_VALIDITY_MS = 500;
    public static final long MIXED_COFEE_VALIDITY_MS = 500;
    public static final long FILTERED_COFFEE_VALIDITY_MS = 500;

}
