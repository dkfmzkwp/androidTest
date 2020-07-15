package com.example.rawfoldertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRead;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = findViewById(R.id.btnRead);
        editText = findViewById(R.id.editText);

        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRead :
                try {
                    InputStream in =getResources().openRawResource(R.raw.kss);
                    byte[] txt = new byte[in.available()];
                    in.read(txt);
                    in.close();
                    editText.setText(new String(txt));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default: break;
        }
    }
}
