package com.example.androidtest20200715;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout slidePage;
    private FrameLayout frameLayout;
    private Button frag1;
    private Button frag2;
    private Button frag3;
    private Animation translate_left;
    private Animation translate_right;
    private Boolean btnFlag = false;
    private CalendarView calendarView;
    private EditText editText;
    private Button btnSave;
    private String fileName;
    private FragmentOne fragment1;
    private FragmentTwo fragment2;
    private FragmentThree fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new FragmentOne();
        fragment2 = new FragmentTwo();
        fragment3 = new FragmentThree();

        //애니메이션 로드
        translate_left = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translate_right = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        findViewByIdfunc();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                fileName = y + "-" + (m + 1) + "-" + d + ".txt";

                //파일 읽기
                try {
                    FileInputStream input = openFileInput(fileName);
                    byte[] txt = new byte[100];

                    input.read(txt);
                    input.close();
                    editText.setText(new String(txt));
                    btnSave.setText("수정");
                } catch (FileNotFoundException e) {
                    //불러올 파일이 없음
                    Log.d("MainActivity", e.getMessage());
                    editText.setText("");
                    editText.setHint("내용 없음");
                    btnSave.setText("쓰기");
                } catch (IOException e1) {
                    Log.d("MainActivity", e1.getMessage());
                    editText.setText("");
                    editText.setHint("불러오기 실패");
                    btnSave.setText("수정");
                }
            }
        });

        btnSave.setOnClickListener(this);
        frag1.setOnClickListener(this);
        frag2.setOnClickListener(this);
        frag3.setOnClickListener(this);

    }

    private void findViewByIdfunc() {
        slidePage = findViewById(R.id.slidePage);
        frameLayout = findViewById(R.id.frameLayout);
        frag1 = findViewById(R.id.frag1);
        frag2 = findViewById(R.id.frag2);
        frag3 = findViewById(R.id.frag3);
        btnSave = findViewById(R.id.btnSave);
        calendarView = findViewById(R.id.calendarView);
        editText = findViewById(R.id.editText);
    }

    //옵션메뉴 inflation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opActivity1 :
                FragmentManager fragmentManager = getSupportFragmentManager();
                List<Fragment> list = fragmentManager.getFragments();
                fragmentManager.beginTransaction().remove(list.get(0)).commit();
            break;
            case R.id.opActivity2 : Intent intent2 = new Intent(this,Sub1Activity.class);
            startActivity(intent2);
            finish();
                break;
            case R.id.opActivity3 : Intent intent = new Intent(this,Sub2Activity.class);
            startActivity(intent);
                finish();
            case R.id.opSlide:
                if (btnFlag == true) {
                    slidePage.startAnimation(translate_right);
                    slidePage.bringToFront();
                    btnFlag = false;
                } else {
                    slidePage.startAnimation(translate_left);
                    slidePage.bringToFront();
                    btnFlag = true;
                }
                break;
            case R.id.opFragment1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment1).commit();
                break;
            case R.id.opFragment2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment2).commit();
                break;
            case R.id.opFragment3 :
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment3).commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void toastPrint(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                try {
                    FileOutputStream out = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String txt = editText.getText().toString();
                    //byte로 바꿔서 저장
                    out.write(txt.getBytes());
                    out.close();
                    toastPrint(fileName + "- 저장 완료");
                } catch (IOException e) {
                    Log.d("MainActivity", e.getMessage());
                    toastPrint("저장 실패");
                }
                break;
            case R.id.frag1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment1).commit();
                break;
            case R.id.frag2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment2).commit();
                break;
            case R.id.frag3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment3).commit();
                break;
        }
    }
}
