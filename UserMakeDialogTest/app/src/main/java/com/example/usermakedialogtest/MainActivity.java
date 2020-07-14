package com.example.usermakedialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvId;
    private TextView tvPw;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIdFunc();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });

    }

    //2.로그인 다이얼로그 불러오기
    private void showLoginDialog() {
        //5.지역변수 선언
        final EditText etId;
        final EditText etPw;

        //4.다이얼로그 화면을 메모리로 올려야한다.
        View dialogView = View.inflate(getApplicationContext(),R.layout.login_dialog,null);
        //6.UI 객체를 찾아서 매치시킨다
        etId = dialogView.findViewById(R.id.etId);
        etPw = dialogView.findViewById(R.id.etPw);

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("아이디 & 패스워드 입력");
        dialog.setIcon(R.mipmap.ic_launcher_round);
        //3.아이디와 패스워드를 입력할 화면 필요

        dialog.setView(dialogView);
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tvId.setText("아이디 : "+etId.getText().toString());
                tvPw.setText("비밀번호 : "+etPw.getText().toString());
            }
        });
        dialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tvId.setText("아이디 : ");
                tvPw.setText("비밀번호 : ");
            }
        });

        dialog.show();
    }

    //1.UI 객체 아이디 찾기
    private void findViewByIdFunc() {
        tvId = findViewById(R.id.tvId);
        tvPw = findViewById(R.id.tvPw);
        btnLogin = findViewById(R.id.btnLogin);
    }
}
