package uncc.parkability.com.parkabilityuncc.data;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Represents the static parking lots this app will provide information for
 *
 * @author Austin Beeler
 * @version 4/19/2015
 */
public enum ParkingLot {
    CONE_DECK_VISITOR("Cone Deck - Visitor", 35.304646, -80.734619, 100),
    WEST_DECK("West Deck", 35.305477, -80.736604, 300),
    LOT_15("Lot 15", 35.307945, -80.732412, 30);

    /** The total number of spaces a lot has */
    private int totalSpaces;

    /** The name of the lot for display purposes */
    private String name;

    /** The latitude coordinate of the lot */
    private double lat;
    /** The longitude coordinate of the lot */
    private double lng;

    /** The percent of spaces used */
    private float percent;

    /**
     * Creates a new lot. Private due to enum requirements
     *
     * @param name The name of the lot
     * @param lat The latitude of the lot
     * @param lng The longitude of the lot
     * @param totalSpaces The total number of spaces the lot has
     */
    private ParkingLot(String name, double lat, double lng, int totalSpaces) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.totalSpaces = totalSpaces;
    }

    /**  @return The total spaces this lot has */
    public int getTotalSpaces() { return totalSpaces; }

    /** @return The number of spaces currently occupied in this lot */
    public int getSpacesUsed() { return ParkingData.getSpaceData(this.ordinal()); }

    /** Updates the percent of spaces filled */
    public void getPercent() {
        percent = ((float) getSpacesUsed() / totalSpaces);
    }

    /** @return The latitude and longitude as an Android friendly object */
    public LatLng getLatLng() { return new LatLng(lat, lng); }

    /** @return The marker options for Google Maps based on the data for this lot */
    public MarkerOptions getMarkerOptions() {
        return new MarkerOptions()
            .position(this.getLatLng())
            .title(this.toString())
            .icon(BitmapDescriptorFactory
            .defaultMarker(this.getHue()));
    }

    /**
     * Gets the hue for the marker based on its occupancy
     * @return A value from 0 (Red) to 120 (Green)
     */
    public float getHue() { return (1 - this.percent) * BitmapDescriptorFactory.HUE_GREEN; }

    @Override
    /** @return The string representation of the lot. Used as the marker title */
    public String toString() { return String.format("%s (%d%%)", this.name, (int) (this.percent * 100)); }
}
