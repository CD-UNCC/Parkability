package uncc.parkability.com.parkabilityuncc.data;

import java.util.Random;

/**
 * Acquires data for a given parking lot.
 *
 * Presently only generates random numbers
 *
 * @auther Austin Beeler
 * @version 4/19/2015.
 */
public class ParkingData {
    /** Used to generate the random numbers for testing purposes */
    private static Random random = new Random();

    /**
     * Will get the number of spaces filled for the given lot ID.
     * Refer to the ParkingLot enum for more information
     *
     * @param lotID The ID of the lot to query for spaces filled
     * @return The number of spaces filled
     */
    public static int getSpaceData(int lotID) {
        // Currently only used for testing purposes and does not access real data
        return random.nextInt(ParkingLot.values()[lotID].getTotalSpaces());
    }
}
