package com.example.sadeqnairat.watashinosudoko;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LevelManager.getInstance().createGrid(this);
        final TextView time = (TextView) findViewById(R.id.textView);

        CountDownTimer timer = new CountDownTimer(1000*60*8 + 20000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText(millisUntilFinished / 1000 + "");
                if(LevelManager.getInstance().getGrid().checkGame())
                {
                    showWin(millisUntilFinished / 1000);
                    this.cancel();


                }
            }

            public void onFinish() {
                time.setText("Time's Up!");
                if(LevelManager.getInstance().getGrid().checkGame())
                {
                    showWin(0);
                    this.cancel();

                }
                else
                    showLost();
            }
        };
        timer.start();


    }

    private void showWin(long secondsLeft){
        Toast.makeText(this, "Great, you've solved the game in " + (500-secondsLeft ) + " Seconds!", Toast.LENGTH_SHORT).show();
        saveDataToPreferencesFile(this, "scores", new String [] {500-secondsLeft + "", 500-secondsLeft + " Seconds"});

    }
    private void showLost(){
        Toast.makeText(this, "You have lost, better luck next time.", Toast.LENGTH_SHORT).show();

    }

    public void restart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Sudoko Re-Conjured.",Toast.LENGTH_SHORT).show();

    }

    public void saveDataToPreferencesFile(Context ctx, String filename, String...data) {
        SharedPreferences prefs = ctx.getSharedPreferences(filename, 0);
        SharedPreferences.Editor editor = prefs.edit();

        for(int i = 0; i < data.length; i += 2) {
            editor.putString(data[i], data[i + 1]);
        }

        editor.commit();
    }



}
