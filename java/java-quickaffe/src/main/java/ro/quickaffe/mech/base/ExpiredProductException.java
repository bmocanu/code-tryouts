package ro.quickaffe.mech.base;

/**
 * @author Bogdan Mocanu
 */
public class ExpiredProductException extends RuntimeException {

    private ExpirableProduct expiredProduct;

    public ExpiredProductException(String message, ExpirableProduct expiredProduct) {
        super(message);
        this.expiredProduct = expiredProduct;
    }

    public ExpirableProduct getExpiredProduct() {
        return expiredProduct;
    }
}
