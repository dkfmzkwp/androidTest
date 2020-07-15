package com.example.lhsactionbaroptionmenutest_0715;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private EditText etMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);


    }

    //옵션메뉴를 inflation 한다
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        etMenu = findViewById(R.id.etMenu);
        //setContentView 에서는 옵션메뉴가 메모리에 올라가지 않기때문에 여기서 아이디를 찾아야한다

        switch (item.getItemId()){
            case R.id.menu1 : btn1.setBackgroundColor(Color.RED); break;
            case R.id.menu2 : btn1.setBackgroundColor(Color.GREEN);
                Toast.makeText(getApplicationContext(),etMenu.getText().toString(),Toast.LENGTH_SHORT).show();
            break;
            case R.id.menu3 : btn1.setBackgroundColor(Color.BLUE); break;
            default: break;
        }

        return super.onOptionsItemSelected(item);
    }
}
