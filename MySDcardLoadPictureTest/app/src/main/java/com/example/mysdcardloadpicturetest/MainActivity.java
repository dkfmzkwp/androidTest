package com.example.mysdcardloadpicturetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button btnNext;
    private Button btnPrev;
    private MyImageView myImageView;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        myImageView = findViewById(R.id.myImageView);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        //외장하드에 있는 이미지를 가져온다
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File[] imageFileArray =new File(path+"/Images").listFiles();
        myImageView.setImagePath(imageFileArray[0].toString());

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index==0)
                    index = imageFileArray.length;
                    index -= 1;
                    myImageView.setImagePath(imageFileArray[index].toString());
                    //***********************
                    myImageView.invalidate();

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index == (imageFileArray.length-1))
                    index = -1;
                    index += 1;
                    myImageView.setImagePath(imageFileArray[index].toString());
                    myImageView.invalidate();

            }
        });
    }
}
