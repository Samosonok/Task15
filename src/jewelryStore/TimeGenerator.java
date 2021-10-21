package jewelryStore;

import java.util.Random;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class TimeGenerator {

    private static int entryTime;
    private static int exitTime;

    public static int getEntryTime() {
        for (int g = 2_000; g < 5_000; g++) {
            entryTime = new Random().nextInt(g);
        }
        return entryTime;
    }

    public static int getExitTime() {
        for (int g = 1_000; g < 8_000; g++) {
            exitTime = new Random().nextInt(g);
        }
        return exitTime;
    }
}
