package ro.bmocanu.javapuzzles.iq.p2;

public class BrilliantClassAgentV1 {
    private Object extremelyExpensiveValue;

    public Object getExtremelyExpensiveValue() {
        System.out.println("Here we create the thing");
        extremelyExpensiveValue = "Loooooong string!";
        new BrilliantClassAgentV2();
        Probl2_Agent.switchClasses("ro/bmocanu/puzzles/", "BrilliantClassAgentV1", "BrilliantClassAgentV2");
        return extremelyExpensiveValue;
    }
}
