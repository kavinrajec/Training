package com.example.hs.fragmentsjson;

/**
 * Created by Kavin HS on 02-12-2015.
 */
import java.util.List;

import org.json.JSONObject;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.android.volley.Response.Listener;
public class ItcJSONResponseListener implements Listener<JSONObject> {
    // Main activity context reference
    private Context context;

    // JSON feed items
    List<ItcJSONItem> items;

    // List adapter reference
    private BaseAdapter adapter;

    // Initialize all the attributes
    public ItcJSONResponseListener(Context context, BaseAdapter adapter, List<ItcJSONItem> items) {
        this.context = context;
        this.items = items;
        this.adapter = adapter;
    }

    // Called when JSON data is ready to be parsed
    public void onResponse(JSONObject response) {
        // Parse JSON results
        ItcJSONUtils.fillList(response, items);
        // Notify the list adapter that the item list is ready
        adapter.notifyDataSetChanged();
        // Display quick info to the user about the success
        Toast.makeText(context, "Loading done !", Toast.LENGTH_LONG).show();
    }
}
