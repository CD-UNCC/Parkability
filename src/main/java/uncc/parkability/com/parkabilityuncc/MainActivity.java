package uncc.parkability.com.parkabilityuncc;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Display;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import uncc.parkability.com.parkabilityuncc.data.Bus;
import uncc.parkability.com.parkabilityuncc.data.BusRoute;
import uncc.parkability.com.parkabilityuncc.data.ParkingData;
import uncc.parkability.com.parkabilityuncc.data.ParkingLot;

import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NONE;
import static uncc.parkability.com.parkabilityuncc.data.BusRoute.green49;
import static uncc.parkability.com.parkabilityuncc.data.BusRoute.red50;
import static uncc.parkability.com.parkabilityuncc.data.BusRoute.yellow47;

/**
 * The main activity for the app
 * @author Austin Beeler
 * @version 4/19/2015
 */
public class MainActivity extends FragmentActivity {
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Marker[] markers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLngBounds.Builder bounds = new LatLngBounds.Builder();

        markers = new Marker[ParkingLot.values().length];
        for (ParkingLot lot : ParkingLot.values()) {
            lot.getPercent();
            markers[lot.ordinal()] = mMap.addMarker(lot.getMarkerOptions());
            bounds.include(lot.getLatLng());
        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), size.x, size.y, 100));
        mMap.setTrafficEnabled(true);
        plotRoutes();
    }

    /** Will go through each lot and update the values based on more current parking information */
    private void updateMarkers() {
    }
    //Plots the individual bus routes
    private void plotRoutes(){
        mMap.addPolyline(new PolylineOptions().add(red50)).setColor(Color.RED);
        mMap.addPolyline(new PolylineOptions().add(green49)).setColor(Color.GREEN);
        mMap.addPolyline(new PolylineOptions().add(yellow47)).setColor(Color.YELLOW);
    }
}
