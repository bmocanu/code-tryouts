package ro.bmocanu.javapuzzles.iq.p6;

public class ATM {
    private static final int MAX_AMOUNT = 60; //Euros
    private int current = 0;

    public synchronized void withdraw(int amount) {
        if (amount > MAX_AMOUNT - current) {
            return;
        }
        current += amount;
    }

    public synchronized void checkIfHacked() {
        if (current > MAX_AMOUNT) {
            System.out.println("Someone is rich :P!");
        } else {
            System.out.println("Maximum limit exceeded, try again tomorrow");
        }
    }
}