package com.example.myphotoshoptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibZoomIn, ibZoomOut, ibRotate, ibBright, ibDark, ibGrey;
    private LinearLayout layoutPicture;
    private MyGraphicView myGraphicView;
    private int flag =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIdFnc();

        //5. 그래픽뷰를 가져온다.
        myGraphicView = new MyGraphicView(this);
        //6. LinearLayout 에 그래픽뷰를 추가하고 중앙에 배치
        layoutPicture.addView(myGraphicView);
        layoutPicture.setGravity(Gravity.CENTER);

        ibZoomIn.setOnClickListener(this);
        ibZoomOut.setOnClickListener(this);
        ibRotate.setOnClickListener(this);
        ibBright.setOnClickListener(this);
        ibDark.setOnClickListener(this);
        ibGrey.setOnClickListener(this);

    }//onCreate

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibZoomIn :
                myGraphicView.sx += 0.2;
                myGraphicView.sy += 0.2;
                break;
            case R.id.ibZoomOut :
                myGraphicView.sx -= 0.2;
                myGraphicView.sy -= 0.2;
                break;
            case R.id.ibRotate :
                myGraphicView.angle += 15.0f;
                break;
            case R.id.ibBright :
                myGraphicView.color += 0.2;
                break;
            case R.id.ibDark :
                myGraphicView.color -= 0.2;
                break;
            case R.id.ibGrey :
                if(flag ==1){
                    myGraphicView.satur = 0.0f;
                    flag = 0;
                }else{
                    myGraphicView.satur = 1.0f;
                    flag = 1;
                }
                break;
            default : break;
        }//switch
        myGraphicView.invalidate();
    }//onClick




    private void findViewByIdFnc() {
        ibZoomIn = findViewById(R.id.ibZoomIn);
        ibZoomOut = findViewById(R.id.ibZoomOut);
        ibRotate = findViewById(R.id.ibRotate);
        ibBright = findViewById(R.id.ibBright);
        ibDark = findViewById(R.id.ibDark);
        ibGrey = findViewById(R.id.ibGrey);
        layoutPicture = findViewById(R.id.layoutPicture);
    }

}
