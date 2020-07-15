package com.example.androidtest20200715;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Sub1Activity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText editText2;
    private FrameLayout frameLayout2;
    private FragmentSubOne fragmentSub1;
    private FragmentSubTwo fragmentSub2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        fragmentSub1 = new FragmentSubOne();
        fragmentSub2 = new FragmentSubTwo();

        button = findViewById(R.id.button);
        editText2 = findViewById(R.id.editText2);
        frameLayout2 = findViewById(R.id.frameLayout2);

        button.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.op2Activity1 : Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.op2Activity2 : FragmentManager fragmentManager = getSupportFragmentManager();
                List<Fragment> list = fragmentManager.getFragments();
                fragmentManager.beginTransaction().remove(list.get(0)).commit();
                break;
            case R.id.op2Fragment1 : getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2, fragmentSub1).commit();
            break;
            case R.id.op2Fragment2 : getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2, fragmentSub2).commit();
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button :
                try {
                    InputStream in =getResources().openRawResource(R.raw.gasa);
                    byte[] txt = new byte[in.available()];
                    in.read(txt);
                    in.close();
                    editText2.setText(new String(txt));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default: break;
        }
    }
}
