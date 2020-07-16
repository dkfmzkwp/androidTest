package com.example.sdcardreadtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRead;
    private EditText etSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = findViewById(R.id.btnRead);
        etSD = findViewById(R.id.etSD);

        //1.AndroidManifest 에서 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/> 추가
        //2.이 앱에서 외장하드(SD카드)에 파일액세스를 허용할것인지 프로그램상으로 요청해야한다.
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        btnRead.setOnClickListener(this);

    }

    //이벤트 처리
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRead :
                try {
                    FileInputStream fin = new FileInputStream("/storage/emulated/0/test_0716.txt");
                    byte[] content = new byte[fin.available()];
                    fin.read(content);
                    fin.close();
                    etSD.setText(new String(content));
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
            default: break;
        }
    }
}
