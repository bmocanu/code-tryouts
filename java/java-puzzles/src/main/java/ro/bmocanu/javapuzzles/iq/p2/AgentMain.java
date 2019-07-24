package ro.bmocanu.javapuzzles.iq.p2;

public class AgentMain {

    public static void main(String[] args) {
        AgentBrilliantClassV1 bc = new AgentBrilliantClassV1();
        System.out.println("Before first call");
        System.out.println(bc.getExtremelyExpensiveValue());
        System.out.println("Before second call");
        System.out.println(bc.getExtremelyExpensiveValue());
        System.out.println("Program finished");
    }

}
