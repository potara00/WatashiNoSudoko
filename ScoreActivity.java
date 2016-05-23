package com.example.sadeqnairat.watashinosudoko;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mohammad Sadeq Nairat on 5/23/2016.
 */
public class ScoreActivity  extends Activity {
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreview);
        listView = (ListView) findViewById(R.id.list);
        listView.setBackgroundColor(Color.WHITE);



        HashMap valuez= readDataFromPreferencesFile(this, "scores");
        String[] values = new String[valuez.size()];
        int i = 0;
        Iterator it = valuez.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            values[i] = pair.getValue() + "";
            i++;
            it.remove(); // avoids a ConcurrentModificationException
        }
        Arrays.sort(values);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        (1+itemPosition)+") Has Finished The Game In" +itemValue , Toast.LENGTH_SHORT)
                        .show();

            }

        });
    }

    public HashMap readDataFromPreferencesFile(Context ctx, String filename) {
        SharedPreferences prefs =  ctx.getSharedPreferences(filename, ctx.MODE_PRIVATE);
        return (HashMap) prefs.getAll();


    }

}