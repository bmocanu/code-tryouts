package ro.quickaffe.mech.base;

public abstract class ExpirableProduct {

    private long expirationTimestamp;

    public boolean isExpired() {
        return expirationTimestamp < System.currentTimeMillis();
    }

    public ExpirableProduct(long validityTimeInMs) {
        this.expirationTimestamp = System.currentTimeMillis() + validityTimeInMs;
    }

}
