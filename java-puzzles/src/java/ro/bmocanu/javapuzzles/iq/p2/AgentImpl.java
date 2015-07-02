package ro.bmocanu.javapuzzles.iq.p2;

import java.io.UnsupportedEncodingException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

public class AgentImpl implements ClassFileTransformer {
    private static Instrumentation inst;
    private static Map<String, byte[]> classBytes = new HashMap<>();

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent started!");
        AgentImpl.inst = inst;
        inst.addTransformer(new AgentImpl());
    }

    public static void switchClasses(String path, String class1, String class2) {
        try {
            System.out.println("Switching bytecode of class " + class1 + " with " + class2);
            byte[] classDef = classBytes.get(path + "/" + class2);
            try {
                // the name appears twice... or thrice if it also contains the source symbols
                // anyway, no loops allowed, so...
                switchClassNames(class1, class2, classDef);
                switchClassNames(class1, class2, classDef);
                switchClassNames(class1, class2, classDef);
                switchClassNames(class1, class2, classDef);
            } catch (Exception e) {
                // discard this exception
            }
            inst.redefineClasses(new ClassDefinition(AgentBrilliantClassV1.class, classDef));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void switchClassNames(String class1, String class2, byte[] classDef) throws UnsupportedEncodingException {
        String classDefLiteral = new String(classDef, "ISO-8859-1");
        int classNamePosition = classDefLiteral.indexOf(class2);
        System.arraycopy(class1.getBytes("ISO-8859-1"), 0, classDef, classNamePosition, class1.length());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        classBytes.put(className, classfileBuffer);
        return classfileBuffer;
    }
}

