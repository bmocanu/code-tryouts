package ro.bmocanu.javapuzzles.iq.p2;

public class BrilliantClass1 {
    private boolean evaluated;
    private Object extremelyExpensiveValue;

    public Object getExtremelyExpensiveValue() {
        try {
            extremelyExpensiveValue.hashCode();
        } catch (NullPointerException e) {
            // dismiss the exception
            extremelyExpensiveValue = compute();
        }
        return extremelyExpensiveValue;
    }

    protected Object compute() {
        return "Loooooong string!";
    }
}