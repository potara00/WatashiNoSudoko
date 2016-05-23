package com.example.sadeqnairat.watashinosudoko;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Set;

/**
 * Created by Sadeq Nairat on 5/23/2016.
 */
public class Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);


    }

    public void startGame(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void readScores(View view){
        Intent intent = new Intent(this, ScoreActivity.class);
        startActivity(intent);

    }


}
