package jewelryStore;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class StoreBreak implements Runnable {

    Store store;

    StoreBreak(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 100; i++) {
            try {
                Thread.sleep(30_000);
                store.getStoreBreak();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
