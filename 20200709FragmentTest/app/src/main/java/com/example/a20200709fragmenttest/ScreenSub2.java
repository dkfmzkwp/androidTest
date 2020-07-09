package com.example.a20200709fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ScreenSub2 extends Fragment {
    private EditText etNum1;
    private EditText etNum2;
    private TextView tvResult;
    private Button btnNum0;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnS1;
    private Button btnS3;
    private Button btn2A2;

    private String operator;

    private Button[] btnArray = new Button[10];
    private int[] idArray = {R.id.btnNum0,R.id.btnNum1,R.id.btnNum2,R.id.btnNum3,R.id.btnNum4,
            R.id.btnNum5,R.id.btnNum6,R.id.btnNum7,R.id.btnNum8,R.id.btnNum9};

    private Button[] calArray = new Button[4];
    private int[] calIdArray = {R.id.btnAdd,R.id.btnSub,R.id.btnMul,R.id.btnDiv};

    private MainActivity mainActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment2,container,false);
        findViewByIdFunc(rootView);

        for(int i = 0; i<btnArray.length; i++){
            final int index;
            index = i;
            btnArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //int index =1; ....~
                    handleBtnNumClickListener(index);
                }
            });
        }

        for(int c = 0; c<calArray.length; c++){
            final int index;
            index = c;
            calArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleCalClickListener(index);
                }
            });
        }

        btnS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeScreen(1);
            }
        });
        btnS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeScreen(3);
            }
        });
        btn2A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity,Sub2Activity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private void handleCalClickListener(int index) {
        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());
        int sum = 0
                ;

        String operaotr = calArray[index].getText().toString();

        switch (operaotr){
            case "더하기" :
                sum = num1 + num2;
                break;
            case "빼기" :
                sum = num1 - num2;
                break;
            case "곱하기" :
                sum = num1 * num2;
                break;
            case "나누기" :
                sum = num1 / num2;
                break;
        }
        tvResult.setText(String.valueOf(sum));
    }


    private void handleBtnNumClickListener(int number) {
        if (etNum1.isFocused() == true) {
            String number1 = etNum1.getText().toString() + number;
            etNum1.setText(number1);
        } else if (etNum2.isFocused() == true) {
            String number2 = etNum2.getText().toString() + number;
            etNum2.setText(number2);
        }
    }

    private void findViewByIdFunc(ViewGroup rootView) {
        etNum1=(EditText)rootView.findViewById(R.id.etNum1);
        etNum2=(EditText)rootView.findViewById(R.id.etNum2);
        tvResult=(TextView)rootView.findViewById(R.id.tvResult);

        //btnNum0~9 findViewById
        for(int i = 0 ; i < btnArray.length ; i++){
            btnArray[i] = (Button)rootView.findViewById(idArray[i]);
        }

        for(int i = 0 ; i < calArray.length ; i++){
            calArray[i] = (Button)rootView.findViewById(calIdArray[i]);
        }

        btnS1=(Button)rootView.findViewById(R.id.btnS1);
        btnS3=(Button)rootView.findViewById(R.id.btnS3);
        btn2A2=(Button)rootView.findViewById(R.id.btn2A2);
    }
}
