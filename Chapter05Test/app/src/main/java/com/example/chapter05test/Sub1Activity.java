package com.example.chapter05test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Sub1Activity extends AppCompatActivity {

    private EditText etSubNum1;
    private EditText etSubNum2;
    private Button btnSubReturn;
    private TextView tvSubCal;
    private TextView tvSubResult;

    private ArrayList<Calculator> calList = new ArrayList<Calculator>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        findViewByIdFunc();

        Intent intent = getIntent();
        if(intent != null){
            getIntentFunc(intent);
        }

        btnSubReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSub01BtnReturnListener(view);
            }
        });
    }

    //값을 되돌려 줘야할때 발생하는 이벤트 핸들러
    private void handleSub01BtnReturnListener(View view) {
        Intent intent = new Intent();   //되돌려줄때는 괄호안에 아무것도 쓰지 않는다
        Calculator calculator = calList.get(0); //onActivityResult() 함수를 콜백처리

        calculator.setResult(Integer.parseInt(tvSubResult.getText().toString()));
        calList.remove(0);
        calList.add(0,calculator);
        intent.putExtra("calList", calList);

        intent.putExtra("result",tvSubResult.getText().toString());
        setResult(1011,intent);
        finish();
    }

    private void getIntentFunc(Intent intent) {
        calList = (ArrayList<Calculator>) intent.getSerializableExtra("calList");
        Calculator calculator = calList.get(0);

        int num1 = calculator.getNumber1();
        int num2 = calculator.getNumber2();
        String operator = calculator.getCalculator();
        int sum = 0;

        switch (operator){
            case "더하기" : sum = num1 + num2;
                tvSubCal.setText("더하기");
                break;
            case "빼기" : sum = num1 - num2;
                tvSubCal.setText("빼기");
                break;
            case "곱하기" : sum = num1 * num2;
                tvSubCal.setText("곱하기");
                break;
            case "나누기" : sum = num1 / num2;
                tvSubCal.setText("나누기");
                break;
        }

        etSubNum1.setText(String.valueOf(num1));
        etSubNum2.setText(String.valueOf(num2));
        tvSubResult.setText(String.valueOf(sum));
    }

    private void findViewByIdFunc() {
        etSubNum1 = (EditText)findViewById(R.id.etSubNum1);
        etSubNum2 = (EditText)findViewById(R.id.etSubNum2);
        btnSubReturn = (Button)findViewById(R.id.btnSubReturn);
        tvSubCal = (TextView)findViewById(R.id.tvSubCal);
        tvSubResult = (TextView)findViewById(R.id.tvSubResult);
    }
}
