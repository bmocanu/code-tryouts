package ro.bmocanu.javapuzzles.iq.p3;

// DO NOT EDIT
public class Rabbit {
    private int rabbitometer;

    public synchronized int enter(Hole hole) {
        rabbitometer++;
        try {
            hole.enter(this);
        } finally {
            rabbitometer--;
        }
        return rabbitometer;
    }
}