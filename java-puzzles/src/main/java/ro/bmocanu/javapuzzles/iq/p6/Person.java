package ro.bmocanu.javapuzzles.iq.p6;

public class Person {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.withdraw(Integer.MIN_VALUE + 65);
        atm.withdraw(Integer.MIN_VALUE);
        atm.checkIfHacked();
    }
}