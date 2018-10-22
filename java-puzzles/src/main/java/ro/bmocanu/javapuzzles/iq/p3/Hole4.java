package ro.bmocanu.javapuzzles.iq.p3;

// the extension of Hole is purely for having all solutions compilable and in the same place
// rename this to Hole, and remove the extension of the original Hole class
public class Hole4 extends Hole {
    public void enter(Rabbit rabbit) {
        Thread debugThread = new Thread(new DebugThatRabbit());
        debugThread.start();
        try {
            debugThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}