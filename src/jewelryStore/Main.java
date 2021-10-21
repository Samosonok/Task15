package jewelryStore;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {

        Store store = new Store();

        Entry entry = new Entry(store);
        Exit exit = new Exit(store);
        StoreBreak storeBreak = new StoreBreak(store);

        new Thread(entry).start();
        new Thread(exit).start();
        new Thread(storeBreak).start();
    }
}
