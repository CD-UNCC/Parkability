package uncc.parkability.com.parkabilityuncc;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;

import uncc.parkability.com.parkabilityuncc.data.BusRoute;
import uncc.parkability.com.parkabilityuncc.data.ParkingLot;

/**
 * The main activity for the app
 * @author Austin Beeler
 * @version 4/19/2015
 */
public class MainActivity extends FragmentActivity {
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Marker[] markers;
    private Polyline[] routes = new Polyline[BusRoute.values().length];
    private LatLngBounds defaultBounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();
        plotRoute(BusRoute.RED_50);
        plotRoute(BusRoute.GREEN_49);
        plotRoute(BusRoute.YELLOW_47);
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

        defaultBounds = bounds.build();

        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(defaultBounds, size.x, size.y, 100));
        mMap.setTrafficEnabled(true);
    }

    /** Will go through each lot and update the values based on more current parking information */
    private void updateMarkers() {
    }

    /**
     * Plots the given BusRoute on the map
     * @param route The route to show
     */
    private void plotRoute(BusRoute route) {
        routes[route.ordinal()] = mMap.addPolyline(route.getPolyLineOptions());
    }

    private void hideRoute(BusRoute route) {
        if (routes[route.ordinal()] != null) {
            routes[route.ordinal()].remove();
            routes[route.ordinal()] = null;
        }
    }

    private void toggleRoute(BusRoute route) {
         if (routes[route.ordinal()] != null)
             plotRoute(route);
         else
             hideRoute(route);
    }
}
