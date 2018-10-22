package ro.bmocanu.javapuzzles.iq.p4;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {
    private static final int CAP = 100;
    private static final int WIN = 1000;
    private Set<Transaction> transactions = new HashSet<Transaction>();

    public synchronized void execute(Transaction trx) {
        if (transactions.size() >= CAP) {
            throw new IllegalStateException("Transactions limit reached! You have been caught !:(");
        } else {
            transactions.add(trx);
        }
    }

    public synchronized void check() {
        if (transactions.size() == WIN) {
            System.out.println("AccountManager HACKED!!! Yay :)");
        }
    }
}