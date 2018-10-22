package ro.bmocanu.javapuzzles.iq.p3;

import com.sun.jdi.ObjectReference;
import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;

import java.io.IOException;
import java.util.Map;

public class DebugThatRabbit implements Runnable {

    @Override
    public void run() {
        try {
            VirtualMachine vm = attachToVm("127.0.0.1", 40000);
            ThreadReference mainThread = getMainThread(vm);
            mainThread.suspend();
            for (ObjectReference objectReference : mainThread.ownedMonitors()) {
                if (objectReference.toString().contains("Rabbit")) {
                    objectReference.setValue(objectReference.referenceType().fieldByName("rabbitometer"), vm.mirrorOf(7));
                }
            }
            mainThread.resume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------------------------------------

    private static VirtualMachine attachToVm(String hostname, int port) throws IOException, IllegalConnectorArgumentsException {
        VirtualMachineManager vmManager = com.sun.jdi.Bootstrap.virtualMachineManager();
        AttachingConnector attConnector = null;
        for (AttachingConnector currentAttConnector : vmManager.attachingConnectors()) {
            if (currentAttConnector.transport().name().equals("dt_socket")) {
                attConnector = currentAttConnector;
                break;
            }
        }

        Map<String, Connector.Argument> params = attConnector.defaultArguments();
        params.get("port").setValue(String.valueOf(port));
        params.get("hostname").setValue(hostname);
        return attConnector.attach(params);
    }

    private static ThreadReference getMainThread(VirtualMachine vm) {
        String threadName = "main";
        for (ThreadReference threadRef : vm.allThreads()) {
            if (threadRef.name().equals(threadName)) {
                return threadRef;
            }
        }
        throw new IllegalStateException("Cannot obtain the main thread (called '" + threadName + "')");
    }
}