package uncc.parkability.com.parkabilityuncc.data;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Interfaces with the NextRide API to present information on the buses around campus to the app
 *
 * @author Austin Beeler
 * @version 4/27/2015
 */
public class BusAPI extends AsyncTask<String, Void, Bus[]> {
    /**
     * The handler to call when the bus data has been acquired and parsed
     */
    private BusHandler handler;

    /**
     * Create a new AsyncTask to query the NextRide API
     *
     * @param handler The handler to call when the bus data has been acquired and parsed
     */
    public BusAPI(BusHandler handler) {
        this.handler = handler;
    }

    @Override
    protected Bus[] doInBackground(String... params) {
        StringBuilder json = new StringBuilder();
        String line;
        HttpClient client = new DefaultHttpClient();
        HttpGet req = new HttpGet(params[0]);
        try {
            HttpResponse res = client.execute(req);
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
            while ((line = reader.readLine()) != null)
                json.append(line);
        } catch (IOException e) {

        }

        return Bus.parseJson(json.toString());
    }

    @Override
    protected void onPostExecute(Bus[] buses) {
        super.onPostExecute(buses);

        handler.handleBuses(buses);
    }

    /**
     * The interface used to call an object to handle the buses parsed by the API
     */
    public static interface BusHandler {
        public void handleBuses(Bus[] buses);
    }
}
