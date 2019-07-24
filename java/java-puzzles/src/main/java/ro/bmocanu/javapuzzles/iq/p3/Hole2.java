package ro.bmocanu.javapuzzles.iq.p3;

// the extension of Hole is purely for having all solutions compilable and in the same place
// rename this to Hole, and remove the extension of the original Hole class
public class Hole2 extends Hole implements Runnable {
    private boolean threadSpawned = false;
    private Rabbit rabbit;

    public void enter(Rabbit rabbit) {
        if (!threadSpawned) {
            threadSpawned = true;
            this.rabbit = rabbit;
            Thread t = new Thread(this);
            t.setDaemon(true);
            t.start();
            try {
                rabbit.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            rabbit.notify();
            try {
                rabbit.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        rabbit.enter(this);
    }
}