package com.example.chapter05test;

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
    private Button btnChange;

    private String operator;
    private final static int REQUEST_SUB1=101;

    private Button[] btnArray = new Button[10];
    private int[] idArray = {R.id.btnNum0,R.id.btnNum1,R.id.btnNum2,R.id.btnNum3,R.id.btnNum4,
            R.id.btnNum5,R.id.btnNum6,R.id.btnNum7,R.id.btnNum8,R.id.btnNum9,
            R.id.btnAdd,R.id.btnSub,R.id.btnMul,R.id.btnDiv};
    private Button[] calArray= new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //UI 객체를 컨트롤러 멤버변수와 연결
        findViewByIdFunc();

        for(int i = 0; i<btnArray.length; i++){
            final int index;
            index = i;
            btnArray[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //int index =1; ....~
                    handleBtnNumClickListener(index); //임시객체에 지역변수 사용불가 -> final로 임시로 선언후에 i값을 넣어준다
                }
            });
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnListener(view);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnListener(view);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnListener(view);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnListener(view);
            }
        });

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,Sub2Activity.class);
               startActivity(intent);
            }
        });
    }//onCreate


    //버튼 이벤트
    private void handleBtnListener(View view) {
        //빈칸일시 메세지
        if(etNum1.getText().toString().equals("") || etNum2.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"숫자를 입력하시오.",Toast.LENGTH_SHORT).show();
            return;
        }
        // view로 주체를 가져옴
        Button clickBtn = (Button) view;

        switch(clickBtn.getText().toString()){
            case "더하기" : operator = "더하기";
            break;
            case "빼기" : operator = "빼기";
            break;
            case "곱하기" : operator = "곱하기";
            break;
            case "나누기" : operator = "나누기";
            break;
        }

        int num1 = Integer.parseInt(etNum1.getText().toString());
        int num2 = Integer.parseInt(etNum2.getText().toString());

        Calculator calculator = new Calculator(num1, num2, operator);
        ArrayList<Calculator> calList = new ArrayList<Calculator>();
        calList.add(calculator);

        Intent intent = new Intent(getApplicationContext(), Sub1Activity.class);
        intent.putExtra("calList", calList);

        startActivityForResult(intent, REQUEST_SUB1);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(intent != null){
            switch (requestCode) {
                case REQUEST_SUB1 :
                    tvResult.setText(intent.getStringExtra("result"));
                    ArrayList<Calculator> calList=(ArrayList<Calculator>)intent.getSerializableExtra("calList");
                    Calculator calculator=calList.get(0);
                    tvResult.setText(String.valueOf(calculator.getResult()));
                    break;
            }
        }
    }

    private void findViewByIdFunc() {
        etNum1=(EditText)findViewById(R.id.etNum1);
        etNum2=(EditText)findViewById(R.id.etNum2);
        tvResult=(TextView)findViewById(R.id.tvResult);

        //btnNum0~9 findViewById
        for(int i = 0 ; i < btnArray.length ; i++){
            btnArray[i] = (Button)findViewById(idArray[i]);
        }

        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnSub=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);

        btnChange=(Button)findViewById(R.id.btnChange);
    }
}




