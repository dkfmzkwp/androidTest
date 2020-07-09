package com.example.a20200709fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView ivMain;
    private ScreenSub1 fragment1;
    private ScreenSub2 fragment2;
    private ScreenSub3 fragment3;
    private ConstraintLayout layoutMainA;
    private FrameLayout frame;
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMain = (ImageView)findViewById(R.id.ivMain);
        layoutMainA = (ConstraintLayout)findViewById(R.id.layoutMainA);
        frame = (FrameLayout)findViewById(R.id.frame);
        tvMain = (TextView)findViewById(R.id.tvMain);

        fragment1 = new ScreenSub1();
        fragment2 = new ScreenSub2();
        fragment3 = new ScreenSub3();

        ivMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frame.setVisibility(View.INVISIBLE);
                changeScreen(1);
            }
        });

        ivMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent (getApplicationContext(),Sub2Activity.class);
                startActivity(intent);
                return false;
            }
        });
        tvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void changeScreen(int no){
        switch (no){
            case 1 : getSupportFragmentManager().beginTransaction().replace(R.id.layoutMainA, fragment1).commit();
            break;
            case 2 : getSupportFragmentManager().beginTransaction().replace(R.id.layoutMainA, fragment2).commit();
                break;
            case 3 : getSupportFragmentManager().beginTransaction().replace(R.id.layoutMainA, fragment3).commit();
                break;
        }
    }
}
