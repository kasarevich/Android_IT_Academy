package by.it_academy.homework.homeWork4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.sql.Time;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by kasarevich on 21.02.2018.
 */

public class CustomWatch extends View {

    private float cx, cy;
    private int[] mHours = {1,2,3,4,5,6,7,8,9,10,11,12};
    private float mRadius = 0;
    private Paint mPaint;
    private Time mTime;
    public CustomWatch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomWatch(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        mPaint = new Paint();
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        cx = w/2;
        cy = h/2;
        mRadius =  w > h ? cy/1.5f : cx/1.5f;

    }

    @Override
    public void onDraw(Canvas canvas) {
        onDrawBackground(canvas);
        onDrawHands(canvas);

        postInvalidateDelayed(500);
        invalidate();
    }

    private void onDrawBackground(Canvas canvas){
        mPaint.setColor(Color.GRAY);
        canvas.drawCircle(cx, cy, mRadius + (mRadius / 3), mPaint);
        mPaint.setColor(Color.LTGRAY);
        canvas.drawCircle(cx, cy, mRadius, mPaint);

        mPaint.setStrokeWidth(mRadius / 20);
        for (int i = 0; i < 12; i++) {
            mPaint.setColor(Color.DKGRAY);
            canvas.rotate(30, cx, cy);
            canvas.drawLine(cx, cy - mRadius, cx, cy - (mRadius / 1.2f), mPaint);
            mPaint.setTextSize(mRadius / 4);
            canvas.drawText(String.valueOf(mHours[i]), cx, cy - (mRadius + mRadius / 10), mPaint);
        }
    }

    private void onDrawHands(Canvas canvas){
        mPaint.setColor(Color.BLACK);
        Calendar calendar = Calendar.getInstance();
        float hour = calendar.get(Calendar.HOUR_OF_DAY);
        if(hour > 12){
            hour = hour-12;
        }
        onDrawHand(canvas,(hour + calendar.get(Calendar.MINUTE)/60)*5f, mRadius/15, mRadius/1.5f);
        onDrawHand(canvas, calendar.get(Calendar.MINUTE), mRadius/20, mRadius/1.2f);
        onDrawHand(canvas, calendar.get(Calendar.SECOND), mRadius/30, mRadius/1.2f);
    }


    private void onDrawHand(Canvas canvas, float loc, float handWidth, float radius){
        float angle = (float)(Math.PI * loc/30 - Math.PI/2);
        mPaint.setStrokeWidth(handWidth);
        canvas.drawLine(cx, cy, (float)(cx + Math.cos(angle)*radius), (float)(cy + Math.sin(angle)*radius), mPaint);
    }
}
