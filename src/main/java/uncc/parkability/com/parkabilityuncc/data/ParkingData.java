package uncc.parkability.com.parkabilityuncc.data;

import java.util.Random;

/**
 * Created by Austin on 4/1/2015.
 */
public class ParkingData {
    private static Random random = new Random();
    public static int getSpaceData(int lotID) {
        return random.nextInt(ParkingLot.values()[lotID].getTotalSpaces());
    }
}
