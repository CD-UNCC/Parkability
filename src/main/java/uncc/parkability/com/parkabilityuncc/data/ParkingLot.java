package uncc.parkability.com.parkabilityuncc.data;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * @author Austin Beeler
 * @version 4/1/2015
 */
public enum ParkingLot {
    CONE_DECK_VISITOR("Cone Deck - Visitor", 35.304646, -80.734619, 100),
    WEST_DECK("West Deck", 35.305477, -80.736604, 300),
    LOT_15("Lot 15", 35.307945, -80.732412, 30);

    private int totalSpaces;
    private String name;
    private double lat, lng;
    private float percent;

    private ParkingLot(String name, double lat, double lng, int totalSpaces) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.totalSpaces = totalSpaces;
    }

    public int getTotalSpaces() { return totalSpaces; }

    public int getSpacesUsed() { return ParkingData.getSpaceData(this.ordinal()); }

    /**
     * Gets the percent value of spaces used to get an appropriate color for the icon
     * @return A value from 0-100
     */
    public void getPercent() {
        percent = ((float) getSpacesUsed() / totalSpaces);
    }

    public LatLng getLatLng() { return new LatLng(lat, lng); }

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
    public String toString() { return String.format("%s (%d%%)", this.name, (int) (this.percent * 100)); }
}
