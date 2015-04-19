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
    LOT_26("Lot 26", 0, 0, 86),
    NORTH_DECK("North Deck", 0, 0, 1171),
    LOT_25("Lot 25", 0, 0, 497),
    LOT_19("Lot 19", 0, 0, 261),
    LOT_18("Lot 18", 0, 0, 94),
    UNION_DECK("Union Deck", 0, 0, 682),
    CRI_1("CRI 1", 0, 0, 1319),
    CRI_2("CRI 2", 0, 0, 128),
    LOT_23("Lot 23", 0, 0, 174),
    LOT_14("Lot 14", 0, 0, 27),
    WEST_DECK("West Deck", 35.305477, -80.736604, 760),
    LOT_7A("Lot 7A", 0, 0, 37),
    LOT_7("Lot 7", 0, 0, 43),
    LOT_101("Lot 101", 0, 0, 60),
    SOUTH_VILLAGE_DECK("South Village Deck", 0, 0, 1101),
    LOT_8("Lot 8", 0, 0, 246),
    LOT_8A("Lot 8A", 0, 0, 55),
    MOORE_SANFORD_LOT("Moore & Sanford Lot", 0, 0, 51),
    LOT_16("Lot 16", 0, 0, 233),
    LOT_20("Lot 20", 0, 0, 105),
    LOT_21("Lot 21", 0, 0, 134),
    MARY_ALEXANDER_ROAD("Mary Alexander Road", 0, 0, 42),
    LOT_12("Lot 12", 0, 0, 84),
    LOT_13("Lot 13", 0, 0, 140),
    GREEK_VILLAGE("Greek Village", 0, 0, 324),
    LOT_6("Lot 6", 0, 0, 607),
    LOT_5("Lot 5", 0, 0, 582),
    LOT_5A("Lot 5A", 0, 0, 251),
    LOT_4A("Lot 4A", 0, 0, 128),
    EAST_DECK_3("East Deck 3", 0, 0, 804),
    EAST_DECK_2("East Deck 2", 0, 0, 539);

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
