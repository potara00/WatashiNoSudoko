package com.example.sadeqnairat.watashinosudoko;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Mohammad Sadeq Nairat on 5/22/2016.
 */
public class Cell extends FatherCell{

    private Paint mPaint;


    public Cell(Context context) {

        super(context);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawNumber(canvas);
        drawLines(canvas);
    }

    private void drawNumber(Canvas canvas){
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);
        Rect bounds = new Rect();
        mPaint.getTextBounds(String.valueOf(getNumber()),0,String.valueOf(getNumber()).length(),bounds);
        if(getNumber() != 0) {
            canvas.drawText(String.valueOf(getNumber()), (getWidth() - bounds.width() - 36), (getHeight() - bounds.height() / 2), mPaint);
        }
        else
        {
            canvas.drawText(" ", (getWidth() - bounds.width() - 36), (getHeight() - bounds.height() / 2), mPaint);

        }

    }

    private void drawLines(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }

}
