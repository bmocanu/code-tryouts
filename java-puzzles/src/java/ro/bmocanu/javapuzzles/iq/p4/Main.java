package ro.bmocanu.javapuzzles.iq.p4;

public class Main {
    public static void main(String args[]) {
        AccountManager manager = new AccountManager();
        manager.execute(new RecursiveTransaction(Transaction.Type.DEPOSIT, 1000, manager));
        manager.check();
    }

    private static class RecursiveTransaction extends Transaction {
        private int loopNr;
        private AccountManager manager;

        public RecursiveTransaction(Type type, long amount, AccountManager manager) {
            super(type, amount);
            this.manager = manager;
            this.loopNr = 1;
        }

        public int hashCode() {
            if (loopNr < 1000) {
                loopNr++;
                manager.execute(this);
            }
            return loopNr--;
        }
    }
}