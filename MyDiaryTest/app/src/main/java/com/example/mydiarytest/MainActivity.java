package com.example.mydiarytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private EditText editText;
    private Button button;
    private String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                filename = year+"_"+(month+1)+"_"+day+".txt";

                //파일 읽기
                try {
                    FileInputStream in =openFileInput(filename);
                    //byte[]
                    byte[] txt = new byte[2000];
                    //정상적으로 읽음
                    in.read(txt);
                    in.close();
                    editText.setText((new String(txt)).trim());
                    button.setText("수정");
                } catch (FileNotFoundException e) {
                    //불러올때 파일이 없음
                    Log.d("MainActivity",e.getMessage());
                    editText.setText("");
                    editText.setHint("내용 없음");
                    button.setText("쓰기");
                }
                catch (IOException e1){
                    //파일은 있는데 읽는도중 오류(ex.글자수 초과)
                    editText.setText("");
                    editText.setHint("불러오기 실패");
                    button.setText("수정");
                }
            }
        });

        //일기를 수정하거나 저장하는 기능 부여
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream out = openFileOutput(filename, Context.MODE_PRIVATE);
                    String txt = editText.getText().toString();
                    //byte로 바꿔서 저장
                    out.write(txt.getBytes());
                    out.close();
                    toastPrint(filename+"- 저장 완료");
                } catch (IOException e) {
                    Log.d("MainActivity",e.getMessage());
                    toastPrint("저장 실패");
                }
            }
        });
    }
    public void toastPrint(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }
}
