package ro.quickaffe.mech;

import ro.quickaffe.mech.base.ExpirableProduct;
import ro.quickaffe.mech.base.ExpiredProductException;

public class Utils {

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void checkExpiration(ExpirableProduct product, String exceptionMessage) {
        if (product.isExpired()) {
            throw new ExpiredProductException(exceptionMessage, product);
        }
    }

}
