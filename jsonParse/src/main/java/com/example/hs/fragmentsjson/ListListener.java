package com.example.hs.fragmentsjson;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by Kavin HS on 02-12-2015.
 */
public class ListListener implements AdapterView.OnItemClickListener {
    // List item's reference
    List<ItcJSONItem> listItems;
    // Calling activity reference
    Activity activity;

    public ListListener(List<ItcJSONItem> aListItems, Activity anActivity) {
        listItems = aListItems;
        activity  = anActivity;
    }

    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        /*// We create an Intent which is going to display data
        Intent i = new Intent(Intent.ACTION_VIEW);
        // We have to set data for our new Intent
        i.setData(Uri.parse(listItems.get(pos).getLink()));
        // And start activity with our Intent
        activity.startActivity(i);*/
     Intent intent = new Intent(activity,WebReaderActivity.class);
        //String link =listItems.get(pos).getLink();
        intent.putExtra("link",listItems.get(pos).getLink());
        activity.startActivity(intent);
    }
}
