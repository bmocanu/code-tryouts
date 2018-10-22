package ro.bmocanu.javapuzzles.iq.p3;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.ProtectionDomain;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// the extension of Hole is purely for having all solutions compilable and in the same place
// rename this to Hole, and remove the extension of the original Hole class
// for this solution add <jdk>/lib/tools.jar as dependency (needed for the Java Tools API (the VirtualMachine & co classes))
public class Hole3 extends Hole implements ClassFileTransformer {
    public static byte[] radditBytes;

    public void enter(Rabbit rabbit) {
        try {
            Instrumentation inst = getInstrumentationForThisVM();
            inst.addTransformer(this);

            // reference Raddit so that the JVM loads the class, and the agent gets the bytes
            new Raddit();

            String classDefLiteral = new String(radditBytes, StandardCharsets.ISO_8859_1);
            classDefLiteral = classDefLiteral.replaceAll("Raddit", "Rabbit");
            inst.redefineClasses(new ClassDefinition(Rabbit.class, classDefLiteral.getBytes(StandardCharsets.ISO_8859_1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // now the new rabbit is installed and we need to visit it once more to run the new byte code
        rabbit.enter(this);
    }

    // ----------------------------------------------------------------

    private static Instrumentation staticInstrumentation;

    public Instrumentation getInstrumentationForThisVM() throws Exception {
        System.out.println("Getting the instrumentation");
        // create a special property to verify our JVM connection
        String magic = UUID.randomUUID().toString() + '/' + System.nanoTime();
        System.setProperty("magic", magic);
        VirtualMachine vm = null;
        for (VirtualMachineDescriptor vd : VirtualMachine.list()) {
            try {
                System.out.println("Found the VM, attaching...");
                vm = VirtualMachine.attach(vd);
                if (magic.equals(vm.getSystemProperties().getProperty("magic")))
                    break;
                System.out.println("Done, detaching...");
                vm.detach();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Loading agent...");
        vm.loadAgent(createJar().getAbsolutePath());
        synchronized (Hole3.class) {
            while (staticInstrumentation == null) Hole3.class.wait();
        }
        System.out.println("Detaching VM");
        vm.detach();
        return staticInstrumentation;
    }

    // create a JAR file for the agent; since our class is already in class path
    // our jar consisting of a MANIFEST declaring our class as agent only
    private static File createJar() throws IOException {
        File f = File.createTempFile("agent", ".jar");
        f.deleteOnExit();
        Charset cs = StandardCharsets.ISO_8859_1;
        try (FileOutputStream fos = new FileOutputStream(f);
             ZipOutputStream os = new ZipOutputStream(fos)) {
            os.putNextEntry(new ZipEntry("META-INF/MANIFEST.MF"));
            ByteBuffer bb = cs.encode("Agent-Class: " + Hole3.class.getName() + "\nCan-Redefine-Classes: true\n");
            os.write(bb.array(), bb.arrayOffset() + bb.position(), bb.remaining());
            os.write(10);
            os.closeEntry();
        }
        return f;
    }

    // invoked when the agent is loaded into the JVM, pass inst back to the caller
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent started");
        synchronized (Hole3.class) {
            staticInstrumentation = inst;
            Hole3.class.notifyAll();
        }
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws
            IllegalClassFormatException {
        if (className.contains("Raddit")) {
            radditBytes = classfileBuffer;
        }
        return classfileBuffer;
    }

}