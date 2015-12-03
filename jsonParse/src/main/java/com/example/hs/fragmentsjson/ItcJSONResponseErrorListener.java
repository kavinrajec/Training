package com.example.hs.fragmentsjson;

/**
 * Created by Kavin HS on 02-12-2015.
 */
import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

public class ItcJSONResponseErrorListener implements ErrorListener {
    // Main activity context reference
    private Context context;

    // Create the listener object
    public ItcJSONResponseErrorListener(Context context) {
        this.context = context;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        // Notify user about problems with loading JSON data.
        Toast.makeText(context, "Loading failed!", Toast.LENGTH_LONG).show();
    }
}

