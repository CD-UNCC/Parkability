package uncc.parkability.com.parkabilityuncc.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Acquires data for a given parking lot.
 *
 * Presently only generates random numbers
 *
 * @auther Austin Beeeeeeeeeeeeeeeeeeeler
 * @version 4/19/2015.
 */
public class ParkingData {
    /** Used to generate the random numbers for testing purposes */
    private static Random random = new Random();

    private static int[][] lotOccupancy = {
        { 85, 84, 83, 82, 80, 80, 81, 82, 83, 79, 75, 71, 67, 55, 43, 31, 19 },
        { 311, 310, 308, 306, 304, 307, 311, 315, 319, 312, 304, 297, 289, 284, 278, 272, 266 },
        { 370, 370, 371, 371, 372, 369, 366, 363, 359, 357, 355, 353, 351, 343, 335, 327, 318 },
        { 260, 260, 260, 260, 259, 258, 256, 255, 253, 250, 246, 243, 239, 234, 228, 222, 216 },
        { 93, 93, 93, 93, 93, 93, 92, 92, 91, 88, 84, 80, 76, 72, 68, 64, 59 },
        { 600, 616, 633, 649, 666, 657, 647, 638, 628, 598, 567, 537, 506, 453, 400, 347, 293 },
        { 298, 315, 333, 351, 369, 351, 332, 313, 294, 293, 292, 291, 290, 244, 197, 151, 104 },
        { 127, 126, 125, 124, 123, 124, 125, 126, 127, 120, 113, 106, 99, 82, 65, 48, 31 },
        { 173, 172, 171, 170, 169, 170, 171, 172, 173, 166, 159, 152, 145, 128, 111, 94, 77 },
        { 19, 20, 22, 23, 25, 25, 25, 25, 26, 25, 23, 22, 20, 20, 20, 20, 21 },
        { 580, 618, 656, 694, 732, 719, 705, 691, 677, 624, 571, 518, 465, 420, 375, 330, 284 },
        { 36, 36, 36, 36, 35, 35, 35, 35, 36, 35, 34, 33, 31, 27, 22, 17, 12 },
        { 43, 43, 43, 43, 43, 43, 43, 43, 42, 41, 40, 39, 38, 38, 38, 38, 39 },
        { 30, 30, 30, 30, 29, 29, 29, 29, 30, 29, 27, 26, 24, 21, 17, 13, 9 },
        { 484, 484, 484, 484, 485, 482, 479, 476, 472, 457, 441, 425, 409, 397, 385, 373, 360 },
        { 243, 241, 239, 237, 235, 237, 239, 241, 244, 238, 232, 226, 220, 218, 216, 214, 211 },
        { 55, 55, 54, 54, 53, 53, 54, 54, 55, 55, 55, 55, 54, 54, 54, 54, 55 },
        { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 50, 50, 49 },
        { 233, 233, 233, 233, 232, 232, 232, 232, 232, 231, 229, 228, 226, 226, 225, 225, 224 },
        { 105, 105, 105, 105, 105, 105, 105, 105, 104, 104, 104, 104, 104, 104, 104, 104, 105 },
        { 133, 133, 133, 133, 133, 133, 133, 133, 133, 133, 132, 131, 130, 130, 130, 130, 129 },
        { 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 42, 42, 41, 40, 39 },
        { 84, 84, 84, 84, 83, 83, 83, 83, 83, 80, 76, 73, 69, 64, 59, 54, 48 },
        { 140, 140, 139, 139, 138, 138, 137, 136, 135, 134, 133, 132, 131, 129, 127, 125, 122 },
        { 171, 170, 169, 168, 167, 167, 167, 167, 166, 167, 168, 169, 171, 169, 167, 165, 163 },
        { 187, 197, 208, 219, 230, 227, 223, 220, 216, 204, 191, 179, 166, 159, 151, 143, 135 },
        { 515, 521, 527, 533, 539, 527, 514, 501, 488, 453, 418, 383, 348, 323, 298, 273, 248 },
        { 76, 101, 126, 151, 176, 167, 158, 149, 140, 123, 106, 89, 72, 61, 49, 37, 25 },
        { 104, 106, 109, 111, 114, 108, 101, 95, 88, 80, 72, 64, 56, 47, 38, 29, 19 },
        { 602, 627, 653, 679, 705, 672, 638, 604, 570, 531, 492, 453, 414, 358, 302, 246, 190 },
        { 533, 530, 526, 523, 519, 517, 514, 511, 508, 501, 493, 486, 478, 450, 422, 394, 366 },
    };

    /**
     * Will get the number of spaces filled for the given lot ID.
     * Refer to the ParkingLot enum for more information
     *
     * @param lotID The ID of the lot to query for spaces filled
     * @return The number of spaces filled
     */
    public static int getSpaceData(int lotID) {
        // Currently only used for testing purposes and does not access real data

        // Generated a random number based on total spaces of lot.
        // Kept for documentation purposes only
        // return random.nextInt(ParkingLot.values()[lotID].getTotalSpaces());

        // Gets the statistic occupancy for the given lot at the current time of day
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(sdf.format(cal.getTime()));

        if (hour < 10) return lotOccupancy[lotID][0];
        if (hour >= 18) return lotOccupancy[lotID][lotOccupancy[lotID].length - 1];
        hour -= 10;

        sdf = new SimpleDateFormat("mm");
        int min = Integer.parseInt(sdf.format(cal.getTime()));

        int minIndex = min / 30;
        if (min >= 30) min -= 30;

        float percent = min / 30f;

        return (int) (lotOccupancy[lotID][hour * 2 + minIndex] * percent);
    }
}
