package ro.bmocanu.javapuzzles.iq.p2;

public class Main {

    public static void main(String[] args) {
        BrilliantClassAgentV1 bc = new BrilliantClassAgentV1();
        System.out.println("Before first call");
        System.out.println(bc.getExtremelyExpensiveValue());
        System.out.println("Before second call");
        System.out.println(bc.getExtremelyExpensiveValue());
        System.out.println("Program finished");
    }

}
