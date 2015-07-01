package ro.bmocanu.javapuzzles.iq.p2;

public class AgentBrilliantClassV1 {
    private Object extremelyExpensiveValue;

    public Object getExtremelyExpensiveValue() {
        System.out.println("Here we create the thing");
        extremelyExpensiveValue = "Loooooong string!";
        new AgentBrilliantClassV2();
        AgentImpl.switchClasses("ro/bmocanu/javapuzzles/iq/p2/", "AgentBrilliantClassV1", "AgentBrilliantClassV2");
        return extremelyExpensiveValue;
    }
}
