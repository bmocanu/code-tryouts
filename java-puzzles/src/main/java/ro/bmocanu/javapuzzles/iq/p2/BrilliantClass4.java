package ro.bmocanu.javapuzzles.iq.p2;

public class BrilliantClass4 {

    private ParallelComputer computer = new ParallelComputer();

    public Object getExtremelyExpensiveValue() {
        return computer.getExtremelyExpensiveValue();
    }

    private static class ParallelComputer implements Runnable {

        private Thread innerThread;
        private Object extremelyExpensiveValue;

        public ParallelComputer() {
            innerThread = new Thread(this);
            innerThread.start();
        }

        public Object getExtremelyExpensiveValue() {
            try {
                innerThread.join();
            } catch (InterruptedException e) {/* ignore */}
            return extremelyExpensiveValue;
        }

        @Override
        public void run() {
            extremelyExpensiveValue = "Loooooooooong string!";
        }
    }
}
