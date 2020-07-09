package com.example.chapter06test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button btnStart;
    private RadioGroup rgChoice;
    private RadioButton rdoCal;
    private RadioButton rdoTime;
    private CalendarView calendarView;
    private TimePicker timePicker;
    private Button btnEnd;
    private TextView tvEnd;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1.화면 내용 로드 - 객체화
        setContentView(R.layout.activity_main);

        //1.UI 객체 찾아서 연결
        findViewByIdFunc();
        //2.이벤트 등록
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });
        //3.예약시작 버튼 누르면 크로노미터 작동 시작
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //크로노미터 시간을 시스템 리얼타임 시간으로 설정
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        //4.예약완료 버튼 누르면 크로노미터 정지
        //4-1. 날짜, 시간 가져와서 tvEnd 에 예약된시간,날짜를 보여준다
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.크로노미터 정지
                chronometer.stop();
                //2.설정된 시간 분을 가져온다.
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                //3.설정된 년 월 일을 가져온다.
                String str = year + "년" + month + "월" + day + "일" + " " + hour + "시" + minute + "분" + "예약됨";
                tvEnd.setText(str);

            }
        });
        //calendarView 이벤트 등록
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                year = y;
                month = m+1;
                day = d;
            }
        });
    }

    private void findViewByIdFunc() {
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        rgChoice = (RadioGroup)findViewById(R.id.rgChoice);
        rdoCal = (RadioButton)findViewById(R.id.rdoCal);
        rdoTime = (RadioButton)findViewById(R.id.rdoTime);
        calendarView = (CalendarView)findViewById(R.id.calendarView);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        tvEnd = (TextView)findViewById(R.id.tvEnd);
    }
}
