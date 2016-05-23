package com.example.sadeqnairat.watashinosudoko;

import android.content.Context;
import android.view.View;

/**
 * Created by Sadeq Nairat on 5/22/2016.
 */
public class FatherCell extends View {

    private int number;

    public boolean isSlave() {
        return slave;
    }

    private boolean slave = true;
    public FatherCell(Context context) {
        super(context);
    }

    public int getNumber() {
        return number;
    }

    public void masterify(){
        slave = false;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void setMasterNumber(int number){
        this.number = number;
        invalidate();
    }
    public void setNumber(int number){
        if(slave)
        this.number = number;
        invalidate();
    }

}
