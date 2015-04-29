package uncc.parkability.com.parkabilityuncc;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Display;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;

import uncc.parkability.com.parkabilityuncc.data.Bus;
import uncc.parkability.com.parkabilityuncc.data.BusAPI;
import uncc.parkability.com.parkabilityuncc.data.BusRoute;
import uncc.parkability.com.parkabilityuncc.data.ParkingLot;

/**
 * The main activity for the app
 * @author Austin Beeler
 * @version 4/27/2015
 */
public class MainActivity extends FragmentActivity implements BusAPI.BusHandler {
    final Handler handler = new Handler();
    final int UPDATE_DELAY = 10 * 1000; // Update three times each minute
    final String NEXT_RIDE_API_VEHICLE_POINTS_URL
            = "http://nextride.uncc.edu/Services/JSONPRelay.svc/GetMapVehiclePoints";

    private Runnable updateTask;
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Marker[] busMarkers;
    private Marker[] lotMarkers;
    private Polyline[] routes = new Polyline[BusRoute.values().length];
    private LatLngBounds defaultBounds;

    @Override
    /** Called when the activity is first started */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();
        plotRoute(BusRoute.RED_50);
        plotRoute(BusRoute.GREEN_49);
        plotRoute(BusRoute.YELLOW_47);

        updateTask = new Runnable() {
            @Override
            public void run() {
                try{
                    updateMap();
                }
                catch (Exception e) {
                    // TODO: handle exception
                }
                finally{
                    //also call the same runnable
                    handler.postDelayed(this, UPDATE_DELAY);
                }
            }
        };
        handler.postDelayed(updateTask, UPDATE_DELAY);
    }

    @Override
    /** Called when the activity is resumed after being paused */
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

        lotMarkers = new Marker[ParkingLot.values().length];
        for (ParkingLot lot : ParkingLot.values()) {
            lot.getPercent();
            lotMarkers[lot.ordinal()] = mMap.addMarker(lot.getMarkerOptions());
            bounds.include(lot.getLatLng());
        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        defaultBounds = bounds.build();

        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(defaultBounds, size.x, size.y, 100));
        // mMap.setTrafficEnabled(true);
        new BusAPI(this).execute(NEXT_RIDE_API_VEHICLE_POINTS_URL);
        toggleLots();
        toggleLots();
    }

    /** Updates each lot and the buses if they are shown */
    private void updateMap() {
        for (ParkingLot lot : ParkingLot.values()) {
            lot.getPercent();
            lotMarkers[lot.ordinal()].setTitle(lot.toString());
            lotMarkers[lot.ordinal()].setIcon(lot.getIcon());
        }

        new BusAPI(this).execute(NEXT_RIDE_API_VEHICLE_POINTS_URL);
    }

    /**
     * Plots the given BusRoute on the map
     * @param route The route to show
     */
    private void plotRoute(BusRoute route) {
        if (routes[route.ordinal()] == null)
            routes[route.ordinal()] = mMap.addPolyline(route.getPolyLineOptions());
    }

    /**
     * Removes the route from the map if it has been drawn
     * @param route The route to remove
     */
    private void hideRoute(BusRoute route) {
        if (routes[route.ordinal()] != null) {
            routes[route.ordinal()].remove();
            routes[route.ordinal()] = null;
        }
    }

    /**
     * If the route has been added to the map, it will be removed
     * If the route has not been added to the map, it will be
     * @param route The route to toggle on the map
     */
    public void toggleRoute(BusRoute route) {
         if (routes[route.ordinal()] != null)
             plotRoute(route);
         else
             hideRoute(route);
    }

    /** Sets the visibility of the parking lot markers to the opposite of what they are now */
    public void toggleLots() {
        boolean toSet = !lotMarkers[0].isVisible();

        for (Marker m : lotMarkers)
            m.setVisible(toSet);
    }

    @Override
    /**
     * Updates the bus markers using new information pulled from the server
     * @param buses The new bus information to add to the map
     */
    public void handleBuses(Bus[] buses) {
        if (busMarkers != null)
            for (Marker m : busMarkers)
                m.remove();

        busMarkers = new Marker[buses.length];

        for (int i = 0; i < buses.length; i++) {
            busMarkers[i] = mMap.addMarker(buses[i].getMarkerOptions());
        }
    }
}
