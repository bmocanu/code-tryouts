package ro.bmocanu.javapuzzles.iq.p1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main_PermGen {

    public static void main7(String[] args) {
        System.out.print("99");
        int size = 1024 * 1024 * 1024;
        List<String> lockList = new LinkedList<>();
        while (size >= 2) {
            try {
                char[] chunk = new char[size];
                Arrays.fill(chunk, (char) new Random().nextInt());
                lockList.add(String.valueOf(chunk).intern());
            } catch (OutOfMemoryError err) {
                // too much? he he
                size = size / 2;
            }
        }
        // Evil! This baby up there leaves zero or one single byte in the PermGen, not
        // enough for the internalizing string below to succeed
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */

        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }

}
