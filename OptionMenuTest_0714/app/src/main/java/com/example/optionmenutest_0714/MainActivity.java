package com.example.optionmenutest_0714;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llBack;
    private Button btnText;
    private Button btnContext1;
    private Button btnContext2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llBack = (LinearLayout) findViewById(R.id.llBack);
        btnText = (Button) findViewById(R.id.btnText);
        btnContext1 = (Button) findViewById(R.id.btnContext1);
        btnContext2 = (Button) findViewById(R.id.btnContext2);

        //ContextMenu 는 어디에서 ContextMenu를 보여야할지 결정해야한다.
        //1. registerForContextMenu();
        registerForContextMenu(btnContext1);
        registerForContextMenu(btnContext2);
        //2. onCreateContextMenu() 오버라이딩
        //3. onContextItemSelected() 오버라이딩

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        //option_menu.xml 을 메모리에 로드시켜서 객체를 만듬.
        menuInflater.inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuRed:
                llBack.setBackgroundColor(Color.RED);
                break;
            case R.id.menuGreen:
                llBack.setBackgroundColor(Color.GREEN);
                break;
            case R.id.menuBlue:
                llBack.setBackgroundColor(Color.BLUE);
                break;
            case R.id.menuSpin:
                btnText.setRotation(45f);
                break;
            case R.id.menuExpansion:
                btnText.setScaleX(2);
                btnText.setScaleY(2);
                break;
            case R.id.btnRed:
                item.setChecked(true);
                btnText.setBackgroundColor(Color.RED);
                break;
            case R.id.btnYellow:
                item.setChecked(true);
                btnText.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.btnBlue:
                item.setChecked(true);
                btnText.setBackgroundColor(Color.BLUE);
                break;
            default:
                Toast.makeText(getApplicationContext(), "@", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //컨텍스트 메뉴를 2개 등록했기때문에 어떤 메뉴인지 구별해서 메모리에 올려야한다. View v 부분에서 구분
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //4.
        MenuInflater menuInflater = getMenuInflater();
        if (v == btnContext1) {
            menuInflater.inflate(R.menu.context_menu1, menu);
        } else if (v == btnContext2) {
            menuInflater.inflate(R.menu.context_menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ctmRed:
                llBack.setBackgroundColor(Color.RED);
                break;
            case R.id.ctmBlue:
                llBack.setBackgroundColor(Color.BLUE);
                break;
            case R.id.ctmGreen:
                llBack.setBackgroundColor(Color.GREEN);
                break;
            case R.id.ctmDownScale:
                btnText.setScaleX(0.5f);
                btnText.setScaleY(0.5f);
                break;
            case R.id.ctmSpin:
                btnText.setRotation(-45f);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
