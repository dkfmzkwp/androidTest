package com.example.sdcardfoldermakeremovetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnMake;
    private Button btnDel;
    private Button btnRead;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMake = findViewById(R.id.btnMake);
        btnDel = findViewById(R.id.btnDel);
        btnRead = findViewById(R.id.btnRead);
        editText = findViewById(R.id.editText);

        btnMake.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnRead.setOnClickListener(this);

        //프로그램으로도 권한 설정
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
    }

    //모든 이벤트를 이 함수에서 관리
    @Override
    public void onClick(View view) {
        //외부 장치(SD카드)가 있는 경로를 가져온다.
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String rootPath = Environment.getRootDirectory().getAbsolutePath();
        Log.d("MainActivity",path);
        File file = new File(path+"/mydir");
        String strList = "";
        switch (view.getId()){
            case R.id.btnMake :
                //디렉토리 생성
                file.mkdir();
                Toast.makeText(getApplicationContext(),"디렉토리 생성",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnDel :
                file.delete();
                Toast.makeText(getApplicationContext(),"디렉토리 제거",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRead :
                File root=new File(rootPath);
                File[] rootFileArray = root.listFiles();
                for(int i =0;i<rootFileArray.length;i++){
                    if(rootFileArray[i].isDirectory()==true){
                        strList += "<폴더>"+rootFileArray[i].toString()+"\n";
                    }else{
                        strList += "<파일>"+rootFileArray[i].toString()+"\n";
                    }
                }
                editText.setText(strList);
                break;
            default: break;
        }
    }
}
