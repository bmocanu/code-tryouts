package ro.bmocanu.javapuzzles.iq.p4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String args[]) throws InterruptedException {
        final AccountManager manager = new AccountManager();
        final ExecutorService executor = Executors.newScheduledThreadPool(1000);
        final CountDownLatch countDownLatch = new CountDownLatch(999);

        for (int index = 0; index < 1000; index++) {
            final boolean lastTransaction = (index == 999);
            executor.execute(new Runnable() {
                public void run() {
                    manager.execute(new CoordinatedTransaction(Transaction.Type.DEPOSIT, 1000, manager, countDownLatch,
                            lastTransaction));
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        manager.check();
    }

    private static class CoordinatedTransaction extends Transaction {
        private AccountManager manager;
        private CountDownLatch countDownLatch;
        private boolean lastThread;

        public CoordinatedTransaction(Type type, long amount, AccountManager manager, CountDownLatch countDownLatch, boolean lastTransaction) {
            super(type, amount);
            this.manager = manager;
            this.countDownLatch = countDownLatch;
            this.lastThread = lastTransaction;
        }

        public int hashCode() {
            try {
                if (!lastThread) {
                    countDownLatch.countDown();
                    manager.wait();
                } else {
                    countDownLatch.await();
                    manager.notifyAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.hashCode();
        }
    }
}