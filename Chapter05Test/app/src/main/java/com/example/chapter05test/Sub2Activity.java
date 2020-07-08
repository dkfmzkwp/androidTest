package com.example.chapter05test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Sub2Activity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private LinearLayout lin1;
    private LinearLayout lin2;
    private LinearLayout lin3;
    private ImageView ivImage1;
    private ImageView ivImage2;
    private ImageView ivImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        findViewByIdFunc();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnListener(view);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnListener(view);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnListener(view);
            }
        });

        ivImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ivImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ivImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void handleBtnListener(View view) {
        Button clickBtn = (Button)view;

        switch (clickBtn.getText().toString()){
            case "이빌죠" : lin1.setVisibility(View.VISIBLE);
                lin2.setVisibility(View.INVISIBLE);
                lin3.setVisibility(View.INVISIBLE);
            break;
            case "라잔" : lin2.setVisibility(View.VISIBLE);
                lin1.setVisibility(View.INVISIBLE);
                lin3.setVisibility(View.INVISIBLE);
            break;
            case "알바트리온" : lin3.setVisibility(View.VISIBLE);
                lin1.setVisibility(View.INVISIBLE);
                lin2.setVisibility(View.INVISIBLE);
            break;
        }
    }

    //아이디 지정
    private void findViewByIdFunc() {
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        lin1 = (LinearLayout)findViewById(R.id.lin1);
        lin2 = (LinearLayout)findViewById(R.id.lin2);
        lin3 = (LinearLayout)findViewById(R.id.lin3);
        ivImage1 = (ImageView)findViewById(R.id.ivImage1);
        ivImage2 = (ImageView)findViewById(R.id.ivImage2);
        ivImage3 = (ImageView)findViewById(R.id.ivImage3);
    }
}
