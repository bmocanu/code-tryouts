package ro.bmocanu.javapuzzles.iq.p5;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        Object[] peopleArray = {"tom", "john"};
        List<String> people = new ShadyArrayList<String>(peopleArray);
        UltraExtraSuperDuperSecureNightClubDoor door = new UltraExtraSuperDuperSecureNightClubDoor(people);
        peopleArray[1] = "risk";
        door.unlock();
    }

    private static class ShadyArrayList<E> extends ArrayList<E> {
        public Object[] elementData;

        public ShadyArrayList(Object[] elementData) {
            this.elementData = elementData;
        }

        @Override
        public Object[] toArray() {
            return elementData;
        }
    }
}