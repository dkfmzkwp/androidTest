package com.example.intenttest20200706;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class SubActivity01 extends AppCompatActivity {

    private EditText sub01EtNumber1;
    private EditText sub01EtNumber2;
    private EditText sub01EtResult;

    private Button sub01BtnReturn;
    private Button sub01BtnCal;

    //private ArrayList<Student> list = new ArrayList<Student>();
    private ArrayList<StuddentParce> list = new ArrayList<StuddentParce>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub01);

        sub01EtNumber1= (EditText) findViewById(R.id.sub01EtNumber1);
        sub01EtNumber2= (EditText) findViewById(R.id.sub01EtNumber2);
        sub01EtResult= (EditText) findViewById(R.id.sub01EtResult);

        sub01BtnCal= (Button) findViewById(R.id.sub01BtnCal);
        sub01BtnReturn= (Button) findViewById(R.id.sub01BtnReturn);

        Intent intent = getIntent();
        if(intent != null){
            getIntentFunction(intent);
        }

        sub01BtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSub01BtnReturnListener(view);
            }
        });

    }//onCreate

    //값을 되돌려 줘야할때 발생하는 이벤트 핸들러
    private void handleSub01BtnReturnListener(View view) {
        //되돌려 줄때는 괄호 안에 아무것도 쓰지 않는다.
        Intent intent = new Intent(); //onActivityResult() 함수를 콜백 처리하기위한 방식
        StuddentParce studdentParce = list.get(0);
        studdentParce.setResult(Integer.parseInt(sub01EtResult.getText().toString()));
        list.remove(0);
        list.add(0,studdentParce);
        intent.putExtra("list",list);

        intent.putExtra("result", sub01EtResult.getText().toString());
        setResult(1011,intent); //resultcode : yes = 1011  no = 1010
        finish();
    }

    private void getIntentFunction(Intent intent) {
//        int number1 = intent.getIntExtra("number1",0);
//        int number2 = intent.getIntExtra("number2",0);
//        String calculate = intent.getStringExtra("calulate");
//
//        int sum = 0;
//        switch (calculate){
//            case "덧셈" : sum = number1 + number2;
//                sub01BtnCal.setText("덧셈");
//            break;
//            case "뺄셈" : sum = number1 - number2;
//                sub01BtnCal.setText("뺄셈");
//            break;
//            case "곱셈" : sum = number1 * number2;
//                sub01BtnCal.setText("곱셈");
//            break;
//            case "나눗셈" : sum = number1 / number2;
//                sub01BtnCal.setText("나눗셈");
//            break;
//        }

        //serializable 받는 방법
//      list = (ArrayList<Student>)intent.getSerializableExtra("list");

        //parcelable 받는 방법
        list=intent.getParcelableArrayListExtra("list");
        StuddentParce studdentParce = list.get(0);

        int number1 = studdentParce.getNumber1();
        int number2 = studdentParce.getNumber2();
        String calculate = studdentParce.getCalculate();

        int sum = 0;
        switch (calculate){
            case "덧셈" : sum = number1 + number2;
                sub01BtnCal.setText("덧셈");
            break;
            case "뺄셈" : sum = number1 - number2;
                sub01BtnCal.setText("뺄셈");
            break;
            case "곱셈" : sum = number1 * number2;
                sub01BtnCal.setText("곱셈");
            break;
            case "나눗셈" : sum = number1 / number2;
                sub01BtnCal.setText("나눗셈");
            break;
        }

        sub01EtNumber1.setText(String.valueOf(number1));
        sub01EtNumber2.setText(String.valueOf(number2));

        sub01EtResult.setText(String.valueOf(sum));

    }
}
