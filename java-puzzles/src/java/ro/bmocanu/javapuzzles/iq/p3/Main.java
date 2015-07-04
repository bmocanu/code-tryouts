package ro.bmocanu.javapuzzles.iq.p3;

public class Main {
    public static void main(String[] args) {
        Rabbit theWhiteRabbit = new Rabbit();
        if (theWhiteRabbit.enter(new Hole()) != 0) {
            System.out.println("Yeahhh, I managed to hide rabbits down the hole....");
        }
    }
}