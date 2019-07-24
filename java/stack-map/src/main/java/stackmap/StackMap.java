package stackmap;

import java.io.Closeable;
import java.io.IOException;

import static stackmap.Utils.doNotify;
import static stackmap.Utils.waitFor;

// ----------------------------------------------------------------------------------------------------

public class StackMap<KType, VType> implements Closeable {

    private Storage<KType, VType> mainStorage;

    private Storage<KType, VType> secondStorage;

    public StackMap() throws InterruptedException {
        mainStorage = new Storage<>();
        secondStorage = new Storage<>();
        mainStorage.copyStorage = secondStorage;
        secondStorage.copyStorage = mainStorage;
        new Thread(mainStorage).start();
        waitFor(mainStorage);
        new Thread(secondStorage).start();
        waitFor(secondStorage);
    }

    public void put(final KType key, VType value) throws InterruptedException {
        mainStorage.value = value;
        mainStorage.key = key;
        waitFor(mainStorage);
    }

    public VType get(KType key) throws InterruptedException {
        mainStorage.searchKey = key;
        waitFor(mainStorage);
        VType result = mainStorage.searchValue;
        switchStorage();
        return result;
    }

    @Override
    public void close() throws IOException {
        mainStorage.terminate = true;
        waitFor(mainStorage);
        secondStorage.terminate = true;
        waitFor(secondStorage);
    }

    private void switchStorage() {
        Storage<KType, VType> copyStorage = mainStorage;
        mainStorage = secondStorage;
        secondStorage = copyStorage;
    }
}

// ----------------------------------------------------------------------------------------------------

class Storage<KType, VType> implements Runnable {

    volatile KType key;
    volatile VType value;
    volatile KType searchKey;
    volatile VType searchValue;
    volatile boolean terminate = false;

    Storage copyStorage;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            doNotify(this);
            while (!terminate) {
                stepIn(0);
            }
            doNotify(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void stepIn(int step) throws InterruptedException {
        while (!terminate && key == null && searchKey == null) {
            Thread.sleep(10);
        }

        KType storedKey = key;
        VType storedValue = value;

        if (key != null) {
            doNotify(this);
            key = null;
            stepIn(step + 1);
        }

        if (searchKey != null) {
            if (searchKey.equals(storedKey)) {
                searchValue = storedValue;
            }
            if (storedKey != null) {
                copyStorage.value = storedValue;
                copyStorage.key = storedKey;
                waitFor(copyStorage);
            }
            if (step == 0) {
                doNotify(this);
                searchKey = null;
            }
        }
    }
}

class Utils {

    @SuppressWarnings("all")
    public static void waitFor(final Object object) {
        synchronized (object) {
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("all")
    public static void doNotify(final Object object) {
        synchronized (object) {
            object.notify();
        }
    }
}
