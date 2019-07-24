package ro.bmocanu.javapuzzles.iq.p2;

import java.util.Stack;

public class BrilliantClass2 {
    private Stack<Probl2_Bin> binStack;

    public BrilliantClass2() {
        binStack = new Stack<>();
        binStack.push(new Probl2_Bin(binStack));
    }

    public Object getExtremelyExpensiveValue() {
        return binStack.peek().getValue();
    }

    // ----------------------------------------------------------------------------------------------------

    private static class Probl2_Bin {

        protected Stack<Probl2_Bin> binStack;

        public Probl2_Bin(Stack<Probl2_Bin> binStack) {
            this.binStack = binStack;
        }

        public Object getValue() {
            Object theValue = "Loooooooooooooong string!!";
            binStack.push(new Probl2_BinWithCache(theValue));
            return theValue;
        }
    }

    private static class Probl2_BinWithCache extends Probl2_Bin {
        private Object expensiveValue;

        public Probl2_BinWithCache(Object expensiveValue) {
            super(null);
            this.expensiveValue = expensiveValue;
        }

        public Object getValue() {
            return expensiveValue;
        }
    }
}
 
