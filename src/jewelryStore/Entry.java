package jewelryStore;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

class Entry implements Runnable {

    Store store;

    Entry(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 2000; i++) {
            store.addClient();
        }
    }
}
