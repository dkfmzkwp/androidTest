package com.example.androidtest20200715;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.List;

public class Sub2Activity extends AppCompatActivity {
    private Button btnPrev;
    private Button btnNext;
    private ImageViewTest imageViewTest;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        imageViewTest = findViewById(R.id.imageViewTest);

        //AndroidManifest 에서 설정한 권한을 프로그램상에서도 설정해야한다
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        //외장 메모리에 있는 이미지를 가져온다
        //이미지 경로 확보
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        //해당 경로 폴더에있는 모든 이미지를 배열로 받아온다
        final File[] imageArray=new File(path+"/Pictures").listFiles();
        //사용자가 만든 이미지뷰에 이미지 적용
        imageViewTest.setImagePath(imageArray[0].toString());

        //이전 버튼 이벤트
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index == 0)
                    index = imageArray.length;
                    index -= 1;
                    imageViewTest.setImagePath(imageArray[index].toString());

                    imageViewTest.invalidate();
            }
        });
        //다음 버튼 이벤트
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index == (imageArray.length-1))
                    index = -1;
                    index += 1;
                    imageViewTest.setImagePath(imageArray[index].toString());

                    imageViewTest.invalidate();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.op3Activity1 :
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.op3Activity2 :
                Intent intent2 = new Intent(this, Sub1Activity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.op3Activity3 :
                FragmentManager fragmentManager = getSupportFragmentManager();
                List<Fragment> list = fragmentManager.getFragments();
                fragmentManager.beginTransaction().remove(list.get(0)).commit();
                break;
            case R.id.op3Activity4 :
                Intent intent3 = new Intent(this,Sub3Activity.class);
                startActivity(intent3);
                finish();
                break;
            case R.id.op3Activity5 :
                Intent intent4 = new Intent(this,Sub4Activity.class);
                startActivity(intent4);
                finish();
                break;
            default : break;
        }
        return super.onOptionsItemSelected(item);
    }
}
