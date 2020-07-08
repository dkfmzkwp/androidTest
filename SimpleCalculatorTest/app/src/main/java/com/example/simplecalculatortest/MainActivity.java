package com.example.simplecalculatortest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnRem;
    private TextView tvResult;
    private double number1 = 0.0;
    private double number2 = 0.0;
    private double sum = 0.0;
    private final static int REQUEST_SUB01 = 101;
    private final static int REQUEST_SUB02 = 102;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnRem = (Button) findViewById(R.id.btnRem);
        tvResult = (TextView) findViewById(R.id.tvResult);


        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하시오.", Toast.LENGTH_SHORT).show();
                    return;
                }
                number1 = Double.parseDouble(etNum1.getText().toString());
                number2 = Double.parseDouble(etNum2.getText().toString());
                String cal = btnAdd.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity01.class);
                Calculator calculator = new Calculator(number1, number2, 0.0, cal);
                ArrayList<Calculator> calLIst = new ArrayList<Calculator>();
                calLIst.add(calculator);
                intent.putExtra("calList", calLIst);

                startActivityForResult(intent, REQUEST_SUB01);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하시오.", Toast.LENGTH_SHORT).show();
                    return;
                }
                number1 = Double.parseDouble(etNum1.getText().toString());
                number2 = Double.parseDouble(etNum2.getText().toString());
                String cal = btnSub.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity01.class);
                Calculator calculator = new Calculator(number1, number2, 0.0, cal);
                ArrayList<Calculator> calLIst = new ArrayList<Calculator>();
                calLIst.add(calculator);
                intent.putExtra("calList", calLIst);

                startActivityForResult(intent, REQUEST_SUB01);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하시오.", Toast.LENGTH_SHORT).show();
                    return;
                }
                number1 = Double.parseDouble(etNum1.getText().toString());
                number2 = Double.parseDouble(etNum2.getText().toString());
                String cal = btnMul.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity01.class);
                Calculator calculator = new Calculator(number1, number2, 0.0, cal);
                ArrayList<Calculator> calLIst = new ArrayList<Calculator>();
                calLIst.add(calculator);
                intent.putExtra("calList", calLIst);

                startActivityForResult(intent, REQUEST_SUB01);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하시오.", Toast.LENGTH_SHORT).show();
                    return;
                }
                number1 = Double.parseDouble(etNum1.getText().toString());
                number2 = Double.parseDouble(etNum2.getText().toString());
                String cal = btnDiv.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity01.class);
                Calculator calculator = new Calculator(number1, number2, 0.0, cal);
                ArrayList<Calculator> calLIst = new ArrayList<Calculator>();
                calLIst.add(calculator);
                intent.putExtra("calList", calLIst);

                startActivityForResult(intent, REQUEST_SUB01);
            }
        });
        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하시오.", Toast.LENGTH_SHORT).show();
                    return;
                }
                number1 = Double.parseDouble(etNum1.getText().toString());
                number2 = Double.parseDouble(etNum2.getText().toString());
                String cal = btnRem.getText().toString();
                Intent intent = new Intent(MainActivity.this, SubActivity01.class);
                Calculator calculator = new Calculator(number1, number2, 0.0, cal);
                ArrayList<Calculator> calLIst = new ArrayList<Calculator>();
                calLIst.add(calculator);
                intent.putExtra("calList", calLIst);

                startActivityForResult(intent, REQUEST_SUB01);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (intent != null) {
            switch (requestCode) {
                case REQUEST_SUB01:
                    ArrayList<Calculator> calList = intent.getParcelableArrayListExtra("calList");
                    Calculator calculator = calList.get(0);
                    tvResult.setText(String.valueOf(calculator.getResult()));
                    break;
                case REQUEST_SUB02:
                    break;
            }
        }
    }
}
