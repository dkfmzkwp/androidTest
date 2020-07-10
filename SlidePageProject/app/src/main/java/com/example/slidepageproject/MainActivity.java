package com.example.slidepageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenClose;
    private Button slideBtnMenu;
    private LinearLayout linSlidingPage;
    private Boolean btnFlag = false;
    private Animation translate_left;
    private Animation translate_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Animation loader
        //뷰를 로드 하는것과 동시에 findViewById 까지
        translate_left = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translate_right = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        btnOpenClose =(Button)findViewById(R.id.btnOpenClose);
        slideBtnMenu =(Button)findViewById(R.id.slideBtnMenu);
        linSlidingPage =(LinearLayout)findViewById(R.id.linSlidingPage);

        btnOpenClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnOpneCloseListener(view);
            }
        });
        slideBtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFlag = true;
                handleBtnOpneCloseListener(view);
            }
        });
    }

    //OPEN 버튼 클릭시 linSlidingPage 나타나고 다시 클릭하면 사라진다.
    private void handleBtnOpneCloseListener(View view) {
        if(btnFlag==true){
            linSlidingPage.startAnimation(translate_right);
            btnOpenClose.setText("OPEN");
            btnFlag=false;

        }else{
            linSlidingPage.startAnimation(translate_left);
            btnOpenClose.setText("CLOSE");
            btnFlag=true;

        }
    }
}
