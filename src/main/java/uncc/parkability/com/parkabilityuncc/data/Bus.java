package uncc.parkability.com.parkabilityuncc.data;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A bus that has a route on campus. Can be updated via the BusAPI
 *
 * @author  Austin Beeeeeeeeeeler
 * @version 4/27/15
 */
public class Bus {
    /**
     * Parses a JSON string and returns the equivalent array of Bus objects
     * @param json The JSON string to parse
     * @return The equivalent array of Bus objects
     */
    public static Bus[] parseJson(String json) {
        try {
            JSONArray parent = new JSONArray(json);
            ArrayList<Bus> buses = new ArrayList<Bus>();
            for (int i = 0; i < parent.length(); i++){
                JSONObject bus = parent.getJSONObject(i);
                buses.add(new Bus(
                    bus.getString("Name"),
                    bus.getDouble("Latitude"),
                    bus.getDouble("Longitude"),
                    bus.getInt("RouteID"),
                    bus.getInt("VehicleID")
                ));
            }
            return buses.toArray(new Bus[0]);
        } catch (JSONException e) { }

        return new Bus[0];
    }

    private String name;
    private LatLng position = null;
    private BusRoute route;
    private int vehicleID;

    /**
     * Constructor for a new Bus object
     * @param name The name of the Bus. Displayed on the marker
     * @param lat The latitude part of the position
     * @param lng The longitude part of the position
     * @param routeID The route id from JSON to convert to a BusRoute
     * @param vehicleID The vehicle id from JSON to prevent duplicates
     */
    public Bus(String name, double lat, double lng, int routeID, int vehicleID){
        this.name = name;
        this.position = new LatLng(lat, lng);
        this.route = BusRoute.getRouteFromID(routeID);
        this.vehicleID = vehicleID;
    }

    /** @return The name of the bus */
    public String getName(){ return this.name; }

    /** @return The latitude and longitude making up this bus's position */
    public LatLng getPosition(){ return this.position; }

    /** @return The BusRoute this bus follows */
    public BusRoute getRoute() { return route; }

    /** @return The vehicle ID of this bus */
    public int getVehicleID() { return vehicleID; }

    @Override
    /** @return The String representation of this bus */
    public String toString() { return name; }

    /** @return The MarkerOptions for this bus to generate a new marker with */
    public MarkerOptions getMarkerOptions() {
        return new MarkerOptions()
                .title(this.toString())
                .position(this.position)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
    }

}
