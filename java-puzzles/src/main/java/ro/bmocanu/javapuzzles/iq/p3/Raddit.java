package ro.bmocanu.javapuzzles.iq.p3;

public class Raddit {
    private int rabbitometer;

    public synchronized int enter(Hole hole) {
        rabbitometer++;
        return rabbitometer;
    }
}