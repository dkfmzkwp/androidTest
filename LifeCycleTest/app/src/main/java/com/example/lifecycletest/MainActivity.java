package com.example.lifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView ivClose;
    private RadioGroup rgImage;
    private RadioButton rdQ10;
    private RadioButton rdGingerBread;
    private String rdoMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI객체 맴버객체참조변수 연결
        ivClose=(ImageView)findViewById(R.id.ivClose);
        rgImage=(RadioGroup)findViewById(R.id.rgImage);
        rdGingerBread=(RadioButton)findViewById(R.id.rdGingerBread);
        rdQ10=(RadioButton)findViewById(R.id.rdQ10);

        //이벤트등록
        ivClose.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //이벤트 처리 함수 정의
                handleIvCloseLongClickListener(view);
                return true;
            }
        });
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleIvCloseClickListener(view);
            }
        });
        //RadioGroup 에서 상태 변화가있는지 감지하는 이벤트 등록
        rgImage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                handleRgImageChangeListener(radioGroup, i);
            }
        });



        Toast.makeText(getApplicationContext(),"onCreate() called",Toast.LENGTH_SHORT).show();
    }

    //RadioGroup 에서 상태 변화가 있을때 이벤트 처리 핸들러 함수
    private void handleRgImageChangeListener(RadioGroup radioGroup, int i) {

        switch(i){
            case R.id.rdGingerBread :
                rdoMessage = rdGingerBread.getText().toString();
                break;
            case R.id.rdQ10 :
                rdoMessage = rdQ10.getText().toString();
                break;
            default:
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    //ImageView Click 할때 처리하는 핸들러 함수
    private void handleIvCloseClickListener(View view) {
        Intent intent = new Intent(getApplicationContext(),SubActivity01.class);

        //부가적인 정보를 포함해서 보낸다.
        intent.putExtra("imageName", rdoMessage);

        startActivity(intent);
    }

    //ImageView LongClick 할때 처리하는 핸들러 함수
    public void handleIvCloseLongClickListener(View view) {
        //activity close
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart() called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume() called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause() called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop() called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy() called",Toast.LENGTH_SHORT).show();
    }




}//onCreate
