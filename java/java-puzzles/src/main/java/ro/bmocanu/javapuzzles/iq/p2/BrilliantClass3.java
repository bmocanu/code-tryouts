package ro.bmocanu.javapuzzles.iq.p2;

class BrilliantClass3 {

    public Object getExtremelyExpensiveValue() {
        return Probl2_LazyClass.expensiveValue;
    }

    private static class Probl2_LazyClass {
        static final Object expensiveValue;

        static {
            expensiveValue = "Loooooooooooooooong string!";
        }
    }
}