package com.example.a20200709fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ScreenSub1 extends Fragment {
    private Chronometer chronometer;
    private Button btnStart;
    private RadioGroup rgChoice;
    private RadioButton rdoCal;
    private RadioButton rdoTime;
    private CalendarView calendarView;
    private TimePicker timePicker;
    private Button btnEnd;
    private TextView tvEnd;
    private Button btnS2;
    private Button btnS3;
    private Button btnA2;
    private LinearLayout screen1;
    private int year;
    private int month;
    private int day;

    private MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity= null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment1,container,false);
        findViewByIdFunc(rootView);

        btnS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mainActivity.changeScreen(2);
           }
        });
        btnS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeScreen(3);
            }
        });
        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity,Sub2Activity.class);
                startActivity(intent);
            }
        });

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

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //크로노미터 시간을 시스템 리얼타임 시간으로 설정
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });

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

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m, int d) {
                year = y;
                month = m+1;
                day = d;
            }
        });

        return rootView;
    }

    private void findViewByIdFunc(ViewGroup rootView) {
        chronometer = (Chronometer)rootView.findViewById(R.id.chronometer);
        btnStart = (Button)rootView.findViewById(R.id.btnStart);
        btnEnd = (Button)rootView.findViewById(R.id.btnEnd);
        rgChoice = (RadioGroup)rootView.findViewById(R.id.rgChoice);
        rdoCal = (RadioButton)rootView.findViewById(R.id.rdoCal);
        rdoTime = (RadioButton)rootView.findViewById(R.id.rdoTime);
        calendarView = (CalendarView)rootView.findViewById(R.id.calendarView);
        timePicker = (TimePicker)rootView.findViewById(R.id.timePicker);
        tvEnd = (TextView)rootView.findViewById(R.id.tvEnd);
        screen1 = (LinearLayout)rootView.findViewById(R.id.screen1);
        btnS2 = (Button)rootView.findViewById(R.id.btnS2);
        btnS3 = (Button)rootView.findViewById(R.id.btnS3);
        btnA2 = (Button)rootView.findViewById(R.id.btnA2);
    }
}
