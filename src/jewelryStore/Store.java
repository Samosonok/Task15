package jewelryStore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

class Store {

    List<Client> jewelryStore = new ArrayList<>();
    Client client = new Client(TimeGenerator.getEntryTime(), TimeGenerator.getExitTime());
    boolean suspendFlag;

    public void addClient() {
        try {
            if (jewelryStore.size() < 5) {
                jewelryStore.add(client);
                System.out.println("\nClient went to the store");
                System.out.println("Number of clients in the store: " + jewelryStore.size());
            }
            Thread.sleep(TimeGenerator.getEntryTime());
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
            Thread.sleep(TimeGenerator.getExitTime());
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
