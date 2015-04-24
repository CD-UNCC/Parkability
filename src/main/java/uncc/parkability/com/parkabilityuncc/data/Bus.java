package uncc.parkability.com.parkabilityuncc.data;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * A bus that has a route on campus. Can be updated via the BusAPI
 *
 * @author  Austin Beeeeeeeeeeler
 * @version 4/19/15
 */
public class Bus {
    private HttpClient client = new DefaultHttpClient();
    private HttpGet request = new HttpGet();
    //Hash ID or name to identifier in json data of bus location?
    private String name;
    private LatLng position = null;
    private double lat, lng = 0;
    public String url = "  ";
    public Bus(String name, LatLng position){
        this.name = name;
        this.position = position;
    }
    public String getName(){
        return this.name;
    }
    public LatLng getPosition(){
        return this.position;
    }
    public void update()throws Exception{
/*        request.setURI(new URI("http://nextride.uncc.edu/Services/JSONPRelay.svc/GetMapVehiclePoints"));
        HttpResponse response = client.execute(request);
        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = in.readLine()) != null) {
            JSONObject data = new JSONObject(line);

            if (data.has("Longitude")) {
                double temp = data.getDouble("Latitude");
                System.out.println(temp);
            }

        }*/
    }

}
