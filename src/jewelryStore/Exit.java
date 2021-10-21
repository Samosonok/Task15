package jewelryStore;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

class Exit implements Runnable {

    Store store;

    Exit(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 2000; i++) {
            store.removeClient();
        }
    }
}
