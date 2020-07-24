package com.example.intenttest20200706;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1;
    private EditText etNumber2;
    private EditText etResult;

    private RadioGroup rgCal;
    private RadioButton rdoAdd;
    private RadioButton rdoSub;
    private RadioButton rdoMul;
    private RadioButton rdoDiv;

    private Button btnSend;

    private final static int REQUEST_SUB01 = 101;
    private final static int REQUEST_SUB02 = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber1=(EditText) findViewById(R.id.etNumber1);
        etNumber2=(EditText) findViewById(R.id.etNumber2);
        etResult=(EditText) findViewById(R.id.etResult);

        rgCal=(RadioGroup) findViewById(R.id.rgCal);
        rdoAdd=(RadioButton) findViewById(R.id.rdoAdd);
        rdoSub=(RadioButton) findViewById(R.id.rdoSub);
        rdoMul=(RadioButton) findViewById(R.id.rdoMul);
        rdoDiv=(RadioButton) findViewById(R.id.rdoDiv);

        btnSend = (Button)findViewById(R.id.btnSend);

        //3개의 데이터를 전송 - subActivity
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleBtnSendListener(view);
            }
        });

    }

    private void handleBtnSendListener(View view) {
        String cal = null;
        Intent intent = new Intent(MainActivity.this, SubActivity01.class);
        //3개 값을 전달한다. putExtra : Bunddle(임시버퍼)
//        intent.putExtra("number1", Integer.parseInt(etNumber1.getText().toString()));
//        intent.putExtra("number2", Integer.parseInt(etNumber2.getText().toString()));
//        switch(rgCal.getCheckedRadioButtonId()){
//            case R.id.rdoAdd : cal = "덧셈";
//            break;
//            case R.id.rdoSub : cal = "뺄셈";
//            break;
//            case R.id.rdoMul : cal = "곱셈";
//            break;
//            case R.id.rdoDiv : cal = "나눗셈";
//            break;
//        }
//        intent.putExtra("calulate",cal);

        //serializable 형식으로 데이터 전송
//        int number1 = Integer.parseInt(etNumber1.getText().toString());
//        int number2 = Integer.parseInt(etNumber2.getText().toString());
//
//        switch(rgCal.getCheckedRadioButtonId()){
//            case R.id.rdoAdd : cal = "덧셈";
//            break;
//            case R.id.rdoSub : cal = "뺄셈";
//            break;
//            case R.id.rdoMul : cal = "곱셈";
//            break;
//            case R.id.rdoDiv : cal = "나눗셈";
//            break;
//        }
//        Student student = new Student(number1, number2, cal);
//        ArrayList<Student> list = new ArrayList<Student>();
//        list.add(student);
//        intent.putExtra("list", list);

        //parcelable 방법으로 데이터 전송
        int number1 = Integer.parseInt(etNumber1.getText().toString());
        int number2 = Integer.parseInt(etNumber2.getText().toString());

        switch(rgCal.getCheckedRadioButtonId()){
            case R.id.rdoAdd : cal = "덧셈";
            break;
            case R.id.rdoSub : cal = "뺄셈";
            break;
            case R.id.rdoMul : cal = "곱셈";
            break;
            case R.id.rdoDiv : cal = "나눗셈";
            break;
        }
        StuddentParce studdentParce = new StuddentParce(number1, number2,cal,0);
        ArrayList<StuddentParce> list = new ArrayList<StuddentParce>();
        list.add(studdentParce);
        intent.putExtra("list", list);

        startActivityForResult(intent, REQUEST_SUB01); //REQUEST_SUB01 - subActivity에서 보냄 받음
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (intent != null) {
            switch (requestCode) {
                case REQUEST_SUB01:
                    // etResult.setText(intent.getStringExtra("result"));
                    // ArrayList<Student> list=(ArrayList<Student>)intent.getSerializableExtra("list");
                    ArrayList<StuddentParce> list = intent.getParcelableArrayListExtra("list");
                    StuddentParce studdentParce = list.get(0);
                    etResult.setText(String.valueOf(studdentParce.getResult()));
                    break;
                case REQUEST_SUB02:
                    break;
            }
        }//if
    }
}
