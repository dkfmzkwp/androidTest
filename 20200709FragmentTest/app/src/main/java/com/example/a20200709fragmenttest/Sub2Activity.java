package com.example.a20200709fragmenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Sub2Activity extends AppCompatActivity {

    private ImageView ivMain2;
    private TextView tvMain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        ivMain2 = (ImageView)findViewById(R.id.ivMain2);
        tvMain2 = (TextView)findViewById(R.id.tvMain2);

        ivMain2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent (getApplicationContext(),MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
        tvMain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
