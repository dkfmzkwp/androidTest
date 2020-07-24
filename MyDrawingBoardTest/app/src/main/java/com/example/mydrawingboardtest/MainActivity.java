package com.example.mydrawingboardtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int flag = 1; //기본값 = 선  1 = 선 2 = 원
    private static final int LINE = 1;
    private static final int CIRCLE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuLine:
                flag = 1;
                break;
            case R.id.menuCircle:
                flag = 2;
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private class Data{
        private int x = -1;
        private int y = -1;

        public Data(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class MyGraphicView extends View {
        private int startX;
        private int startY;
        private int stopX;
        private int stopY;
        private int moveX;
        private int moveY;
        private ArrayList<Data> list;

        public MyGraphicView(Context context) {
            super(context);
            this.startX = -1;
            this.startY = -1;
            this.stopX = -1;
            this.stopY = -1;
            this.moveX = -1;
            this.moveY = -1;
            list = new ArrayList<Data>();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);

            switch (flag){
                case LINE :
                    canvas.drawLine(startX,startY,stopX,stopY,paint);
                    break;
                case CIRCLE :
                    //두점사이 거리
                    int radius = (int) Math.sqrt(Math.pow((stopX-startX),2)+Math.pow((stopY-startY),2));
                    canvas.drawCircle(startX,startY,radius,paint);
                    break;
                default: break;
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    startX = (int)event.getX();
                    startY = (int)event.getY();
                    list.clear();
                    break;
                case MotionEvent.ACTION_MOVE:
                    moveX = (int)event.getX();
                    moveY = (int)event.getY();
                    Data data = new Data(moveX,moveY);
                    list.add(data);
                    break;
                case MotionEvent.ACTION_UP:
                    stopX = (int)event.getX();
                    stopY = (int)event.getY();
                    this.invalidate();
                    Log.d("MyGraphicView","이동횟수="+list.size());
                    break;
            }

            return true;
        }
    }
}
