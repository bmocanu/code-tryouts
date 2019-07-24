package ro.bmocanu.javapuzzles.iq.p4;

public class Transaction {
    public enum Type {
        DEPOSIT,
        WITHDRAW
    }

    private final Type type;
    private final long amount;

    public Transaction(Type type, long amount) {
        this.type = type;
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction [type=" + type + ", amount=" + amount + "]";
    }
}