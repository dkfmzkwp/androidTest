package com.example.lifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity01 extends AppCompatActivity {

    private ImageView ivPicture;
    private ImageButton ibReturn;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub01);

        ivPicture=(ImageView)findViewById(R.id.ivPicture);
        ibReturn=(ImageButton)findViewById(R.id.ibReturn);
        tvTitle=(TextView)findViewById(R.id.tvTitle);

        ibReturn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                handleIbReturnTouchListener(view, motionEvent);
                return false;
            }
        });

        //Intent 객체를 가져온다.
        Intent intent = getIntent();
        String imageName = intent.getStringExtra("imageName");
        if(imageName != null){
            hanfleIntentFunction(imageName);
        }
    }

    //Intent 값을 받아서 처리해주는 함수
    private void hanfleIntentFunction(String imageName) {
        switch (imageName){
            case "진저브레드" :
                ivPicture.setImageResource(R.drawable.gingerbread);
                tvTitle.setText("진저브레드");
                break;
            case "Q10" :
                ivPicture.setImageResource(R.drawable.q10);
                tvTitle.setText("Q10");
                break;
            default:
        }
    }

    //1. 돌아가기 이미지 버튼 눌렀을때 처리하는 핸들러 함수
    private void handleIbReturnTouchListener(View view, MotionEvent motionEvent) {
        finish();
    }
}
