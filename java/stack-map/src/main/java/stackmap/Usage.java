package stackmap;

import java.io.IOException;

public class Usage {

    public static void main(String[] args) throws InterruptedException, IOException {
        try (StackMap<Integer, String> map = new StackMap<>()) {
            map.put(1, "one");
            map.put(2, "two");
            map.put(3, "three");

            System.out.println(map.get(2));
            System.out.println(map.get(1));
            System.out.println(map.get(3));
        }
    }
}
