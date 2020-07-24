package com.example.toastlocationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast toast = Toast.makeText(getApplicationContext(),"Message",Toast.LENGTH_SHORT);

               //모든 핸드폰의 중앙위치 구하기
                Display display =((WindowManager)getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                int displayX = (int)((Math.random())*display.getWidth());
                int dispalyY = (int)((Math.random())*display.getHeight());
               toast.setGravity(Gravity.TOP | Gravity.LEFT,displayX,dispalyY);
               toast.show();
            }
        });
    }
}
