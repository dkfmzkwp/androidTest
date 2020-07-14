package com.example.option_contextmenutest_0714;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost tabHost;
    private TabHost.TabSpec tabOne;
    private TabHost.TabSpec tabTwo;
    private TabHost.TabSpec tabThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(R.id.tabhost);

        tabHost.setup(getApplicationContext(),getSupportFragmentManager(),R.id.tabRealContent);

        tabOne = tabHost.newTabSpec("ONE").setIndicator("화면1");
        tabTwo = tabHost.newTabSpec("TWO").setIndicator("화면2");
        tabThree = tabHost.newTabSpec("THREE").setIndicator("화면3");

        tabHost.addTab(tabOne, FragmentOne.class, null);
        tabHost.addTab(tabTwo, FragmentTwo.class, null);
        tabHost.addTab(tabThree, FragmentThree.class, null);

        tabHost.setCurrentTab(2);
    }
    protected void changeFragment(int no){
        tabHost.setCurrentTab(no);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.btnScreen2 : Intent intent2 = new Intent(this, Sub1Activity.class);
            startActivity(intent2);
                break;
                default:
        }
        return super.onOptionsItemSelected(item);
    }
}
