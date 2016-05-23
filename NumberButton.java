package com.example.sadeqnairat.watashinosudoko;

/**
 * Created by Mohammad Sadeq Nairat on 5/23/2016.
 */
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NumberButton extends Button implements OnClickListener{

    private int number;

    public NumberButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        LevelManager.getInstance().setNumber(number);
        Cell[][] allCells = LevelManager.getInstance().getGrid().getGrid();
        for(int i = 0 ; i < 9 ; i ++){
            for(int j = 0 ; j < 9 ; j ++){
                if(allCells[i][j].isSlave()){
                    allCells[i][j].setBackgroundColor(Color.parseColor("#ffd27f"));
                }
            }
        }
    }

    public void setNumber(int number){
        this.number = number;
    }
}