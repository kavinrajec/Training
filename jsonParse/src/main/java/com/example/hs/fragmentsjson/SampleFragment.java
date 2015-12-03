package com.example.hs.fragmentsjson;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kavin HS on 02-12-2015.
 */
public class SampleFragment extends Fragment {

    // Volley's request queue
    private RequestQueue requestQueue;

    // JSON feed items
    List<ItcJSONItem> jsonItems;

    public SampleFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, true);
        ListView itcItems = (ListView) view.findViewById(R.id.listMainView);

        // Initialize the items list
        jsonItems = new ArrayList<ItcJSONItem>();

        // Get the reference to the ListView

        // Create a list adapter
        ArrayAdapter<ItcJSONItem> adapter = new ArrayAdapter<ItcJSONItem>(
                getActivity(),android.R.layout.simple_list_item_1, jsonItems);
        // Set list adapter for the ListView
        itcItems.setAdapter(adapter);

        // Set list view item click listener
        itcItems.setOnItemClickListener(new ListListener(jsonItems, getActivity()));

        // Create the request queue
        requestQueue = Volley.newRequestQueue(getActivity());

        // Read JSON data
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "http://www.itcuties.com/feed/json",
                null,
                new ItcJSONResponseListener(getActivity(), adapter, jsonItems),
                new ItcJSONResponseErrorListener(getActivity()));

        // Add the request to the queue
        requestQueue.add(jsonObjectRequest);


        return view;
    }
}
