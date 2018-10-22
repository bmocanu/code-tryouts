package stackmap;

import java.io.Closeable;
import java.io.IOException;

/**
 * NOT WORKING YET
 * <p>
 * Gotta tweak those wait/notify ops a bit, currently throws IllegalMonitorStateException
 */
class StackMap2 implements Closeable {

    StackMap2.Storage mainStorage;
    StackMap2.Storage secondStorage;

    public StackMap2() {
        mainStorage = new StackMap2.Storage();
        secondStorage = new StackMap2.Storage();
        mainStorage.copyStorage = secondStorage;
        secondStorage.copyStorage = mainStorage;
        new Thread(mainStorage).start();
        new Thread(secondStorage).start();
    }

    public void put(Object key, Object value) throws InterruptedException {
        mainStorage.value = value;
        mainStorage.key = key;
        mainStorage.key.wait();
    }

    public Object get(Object key) throws InterruptedException {
        mainStorage.searchKey = key;
        mainStorage.searchKey.wait();
        Storage copyStorage = mainStorage;
        mainStorage = secondStorage;
        secondStorage = copyStorage;
        return copyStorage.searchValue;
    }

    @Override
    public void close() throws IOException {
        mainStorage.terminate = true;
        secondStorage.terminate = true;
    }

    // ----------------------------------------------------------------------------------------

    static class Storage implements Runnable {

        Object sync = new Object();

        Object key;

        Object value;

        Object searchKey;

        Object searchValue;

        boolean terminate = false;

        StackMap2.Storage copyStorage;

        @Override
        public void run() {
            try {
                stepIn(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sync.notify();
        }

        private void stepIn(int step) throws InterruptedException {
            while (!terminate && value == null && searchKey == null) {
                Thread.sleep(10);
            }

            Object storedKey = key;
            Object storedValue = value;

            if (value != null) {
                value = null;
                sync.notify();
                stepIn(step + 1);
            }

            if (searchKey != null) {
                if (searchKey.equals(storedKey)) {
                    searchValue = storedValue;
                }
                if (step < 0) {
                    this.notify();
                    stepIn(0);
                } else {
                    copyStorage.key = storedKey;
                    copyStorage.value = storedValue;
                    copyStorage.sync.wait();
                }
            }
        }

    }
}

// ----------------------------------------------------------------------------------------------------

