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
    LOT_26("Lot 26", 35.312453, -80.731110, 86),
    NORTH_DECK("North Deck", 35.313456, -80.731488, 1171),
    LOT_25("Lot 25", 35.312895, -80.732679, 497),
    LOT_19("Lot 19", 35.308360, -80.735677, 261),
    LOT_18("Lot 18", 35.309236, -80.736053, 94),
    UNION_DECK("Union Deck", 35.309192, -80.735635, 682),
    CRI_1("CRI 1", 35.309198, -80.743459, 1319),
    CRI_2("CRI 2", 35.310406, -80.743309, 128),
    LOT_23("Lot 23", 35.309736, -80.741522, 174),
    LOT_14("Lot 14", 35.306795, -80.737885, 27),
    WEST_DECK("West Deck", 35.305477, -80.736604, 760),
    LOT_7A("Lot 7A", 35.303949, -80.736448, 37),
    LOT_7("Lot 7", 35.304614, -80.735847, 43),
    LOT_101("Lot 101", 35.297522, -80.736426, 60),
    SOUTH_VILLAGE_DECK("South Village Deck", 35.300622, -80.736190, 1101),
    LOT_8("Lot 8", 35.300630, -80.734903, 246),
    LOT_8A("Lot 8A", 35.301559, -80.733991, 55),
    MOORE_SANFORD_LOT("Moore & Sanford Lot", 35.302627, -80.733090, 51),
    LOT_16("Lot 16", 35.308931, -80.730654, 233),
    LOT_20("Lot 20", 35.310270, -80.732650, 105),
    LOT_21("Lot 21", 35.311233, -80.731148, 134),
    MARY_ALEXANDER_ROAD("Mary Alexander Road", 35.309971, -80.729339, 42),
    LOT_12("Lot 12", 35.311461, -80.728750, 84),
    LOT_13("Lot 13", 35.311049, -80.727516, 140),
    GREEK_VILLAGE("Greek Village", 35.312608, -80.725918, 324),
    LOT_6("Lot 6", 35.309219, -80.725896, 607),
    LOT_5("Lot 5", 35.307337, -80.727044, 582),
    LOT_5A("Lot 5A", 35.307433, -80.725531, 251),
    LOT_4A("Lot 4A", 35.306820, -80.725220, 128),
    EAST_DECK_3("East Deck 3", 35.305971, -80.726122, 804),
    EAST_DECK_2("East Deck 2", 35.305358, -80.726894, 539);

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
