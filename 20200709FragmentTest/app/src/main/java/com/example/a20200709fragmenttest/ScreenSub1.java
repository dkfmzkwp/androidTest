package com.example.a20200709fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
