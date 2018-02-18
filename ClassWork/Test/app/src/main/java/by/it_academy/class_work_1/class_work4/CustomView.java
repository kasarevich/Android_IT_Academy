package by.it_academy.class_work_1.class_work4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kasarevich on 16.02.2018.
 */

    public class CustomView extends View {

    private Paint paint;
    private float radius;
    private float cx;
    private float cy;
    private RectF rect;

    public CustomView(Context context) {
        super(context);
        init();
    }


    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
    }

    //оскольку метод onDraw вызывается часто, расчерты выносим из него сюда
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) { // при каждом изменении или пересоздании экрана создается
        super.onSizeChanged(w, h, oldw, oldh);

        cx = w/2;
        cy=h/2;
        radius =  w > h ? cy/4 : cx/4;

        float wRec = w * 0.9f; // w - 100% -90%
        float hRec = h * 0.2f;

        rect = new RectF();
        rect.left = (w - wRec) / 2;
        rect.top = (h-hRec)/2;
        rect.right = w - rect.left;
        rect.bottom = h - rect.top;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Если лайаут, в котором наш вью выделяет место не мач пэрэнт,
        // а wrap content, о в этом методе определяем, сколько места выделять
        // под текущий вью
    }
*/
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle( cx, cy, radius, paint);

        canvas.drawLine(0,0, canvas.getHeight(), canvas.getWidth(), paint);

        paint.setColor(Color.RED);
        canvas.drawRect(rect, paint);

        //canvas.save();
       // canvas.rotate(90, cx, cy); hw
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                rect.contains(event.getX(), event.getY()); // Проверяем, попали ли в зону прямоугольника
            break;
        }
            case MotionEvent.ACTION_UP:{
                break;
        }
            case MotionEvent.ACTION_MOVE:{
                cx = event.getX();
                cy = event.getY();
                invalidate();
                return false;
        }
        }

        return true;
    }
}
