package com.example.simplecalculatortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SubActivity01 extends AppCompatActivity {

    private EditText etSubNum1;
    private EditText etSubNum2;
    private Button btnSubReturn;
    private TextView tvSubCal;
    private TextView tvSubResult;

    private ArrayList<Calculator> calList = new ArrayList<Calculator>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub01);

        etSubNum1 = (EditText)findViewById(R.id.etSubNum1);
        etSubNum2 = (EditText)findViewById(R.id.etSubNum2);
        btnSubReturn = (Button)findViewById(R.id.btnSubReturn);
        tvSubCal = (TextView)findViewById(R.id.tvSubCal);
        tvSubResult = (TextView)findViewById(R.id.tvSubResult);

        btnSubReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Calculator calculator = calList.get(0);
                calculator.setResult(Double.parseDouble(tvSubResult.getText().toString()));
                calList.remove(0);
                calList.add(0,calculator);
                intent.putExtra("calList", calList);

                intent.putExtra("result", tvSubResult.getText().toString());
                setResult(101,intent);
                finish();
            }
        });

        Intent intent = getIntent();
        if(intent != null){
            getIntentFunction(intent);
        }
    }

    private void getIntentFunction(Intent intent) {
        calList= intent.getParcelableArrayListExtra("calList");
        Calculator calculator = calList.get(0);

        double number1 = calculator.getNumber01();
        double number2 = calculator.getNumber02();
        String cal = calculator.getCalculator();
        double sum = 0.0;

        switch (cal){
            case "더하기" : sum = number1 + number2;
                tvSubCal.setText("더하기");
                break;
            case "빼기" : sum = number1 - number2;
                tvSubCal.setText("빼기");
                break;
            case "곱하기" : sum = number1 * number2;
                tvSubCal.setText("곱하기");
                break;
            case "나누기" : sum = number1 / number2;
                tvSubCal.setText("나누기");
                break;
            case "나머지" : sum = number1 % number2;
                tvSubCal.setText("나머지");
                break;
        }

        etSubNum1.setText(String.valueOf(number1));
        etSubNum2.setText(String.valueOf(number2));
        tvSubResult.setText(String.valueOf(sum));
    }
}
