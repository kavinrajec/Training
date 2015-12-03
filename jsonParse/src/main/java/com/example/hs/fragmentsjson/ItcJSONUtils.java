package com.example.hs.fragmentsjson;

/**
 * Created by Kavin HS on 02-12-2015.
 */
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class ItcJSONUtils {

    /**
     * Method fills list with data from the JSON response.
     */
    public static void fillList(JSONObject response, List<ItcJSONItem> items) {
        try{
            // Get the data array containing posts
            JSONArray jsonArray = response.getJSONArray("posts");

            // Get each post data
            for(int i=0; i < jsonArray.length(); i++){
                // Get an object which represents post
                JSONObject jsonPostObject = jsonArray.getJSONObject(i);

                // Create a data object and fill it with data
                ItcJSONItem item = new ItcJSONItem();
                item.setTitle(jsonPostObject.optString("title"));
                item.setLink(jsonPostObject.optString("permalink"));

                // Add new object to the list
                items.add(item);
            }
        }
        catch(Exception e) {
            // Report problems
            Log.e("ITCVolleyExample::ItcJSONParser", "JSON parsing error!");
        }
    }
}
