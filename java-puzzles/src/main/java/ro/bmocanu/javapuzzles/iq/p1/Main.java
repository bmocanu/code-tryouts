package ro.bmocanu.javapuzzles.iq.p1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.security.AccessControlException;

public class Main {

    public static void main(String[] args) {
        class Out {
            void printf(String format, int value) {
                System.out.print("99");
            }
        }
        class SystemClass {
            Out out = new Out();
        }
        SystemClass System = new SystemClass();
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */

        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }

    // ----------------------------------------------------------------------------------------------------

    public static void main2(String[] args) {
        System.out.print("99");
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */

        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }

    // ----------------------------------------------------------------------------------------------------

    public static void main3(String[] args) {
        System.out.print("99");
        System.exit(0);
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */

        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }

    // ----------------------------------------------------------------------------------------------------

    public static void main4(String[] args) {
        System.out.print("99");
    }

    public void method2() {
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */
        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }

    // ----------------------------------------------------------------------------------------------------

    public static void main5(String[] args) {
        System.out.print("99");
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // do nothing
            }
        });
        System.setOut(null);
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */

        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }

    // ----------------------------------------------------------------------------------------------------

    public static void main6(String[] args) {
        System.out.print("99");
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPropertyAccess(String key) {
                throw new AccessControlException("access denied");
            }
        });
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */

        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }

    // ----------------------------------------------------------------------------------------------------

    public static void main8(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        // Yea yea yea, I know. No reflection...
        Class clazz = Class.forName("java.lang.Integer$IntegerCache");
        Field cacheField = clazz.getDeclaredField("cache");
        cacheField.setAccessible(true);
        Integer[] cache = (Integer[]) cacheField.get(clazz);
        cache[194] = 99;
        /*
        YOU CAN EDIT ONLY THIS AREA. THIS TIME NO RULES AND NO RESTRICTIONS
        */

        // NO EDIT BELOW THIS LINE.
        System.out.printf("%d", 33 + 33);
    }
}
