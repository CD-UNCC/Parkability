package uncc.parkability.com.parkabilityuncc.data;

import com.google.android.gms.maps.model.LatLng;

/**
 * A bus that has a route on campus. Can be updated via the BusAPI
 *
 * @author  Austin Beeler
 * @version 4/19/15
 */
public class Bus {
    /** The route this bus will follow */
    private BusRoute route;

    /** The latitude and longitude of the bus */
    private LatLng location;
}
