package jewelryStore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

class Store {

    List<Client> jewelryStore = new ArrayList<>();
    Client client = new Client();
    boolean suspendFlag;
    ThreadLocalRandom random = ThreadLocalRandom.current();

    public void addClient() {
        try {
            if (jewelryStore.size() < 5) {
                jewelryStore.add(client);
                System.out.println("\nClient went to the store");
                System.out.println("Number of clients in the store: " + jewelryStore.size());
            }
            Thread.sleep(random.nextLong(2_000, 5_000));
            synchronized (this) {
                while (suspendFlag) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void removeClient() {
        try {
            Thread.sleep(random.nextLong(1_000, 8_000));
            if (!jewelryStore.isEmpty()) {
                jewelryStore.remove(0);
                System.out.println("\nClient left the store");
                System.out.println("Number of clients in the store: " + jewelryStore.size());
            }
            synchronized (this) {
                while (suspendFlag) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getStoreBreak() {
        try {
            jewelryStore.clear();
            System.out.println("\nBreak 10 seconds");
            System.out.println("Number of clients in the store: " + jewelryStore.size());
            suspend();
            Thread.sleep(10_000);
            resume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void suspend() {
        suspendFlag = true;
    }

    synchronized void resume() {
        suspendFlag = false;
        notifyAll();
    }
}
