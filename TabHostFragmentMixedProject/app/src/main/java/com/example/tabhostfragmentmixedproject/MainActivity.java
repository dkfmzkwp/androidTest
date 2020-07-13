package com.example.tabhostfragmentmixedproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost tabHost;
    private TabHost.TabSpec tabSpecOne;
    private TabHost.TabSpec tabSpecTwo;
    private TabHost.TabSpec tabSpecThree;

    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);

        //tabHost 에 fragmentManager 를 tabcontent 가 아닌 다른 framelayout 을 지정
        tabHost.setup(getApplicationContext(),getSupportFragmentManager(),R.id.tabRealContent);

        imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.tab_one);

        //tabWidget에 버튼을 넣는 방법
        //tag = 대문자
        tabSpecOne = tabHost.newTabSpec("ONE").setIndicator(imageView);
        tabSpecTwo = tabHost.newTabSpec("TWO").setIndicator("화면2");
        tabSpecThree = tabHost.newTabSpec("THREE").setIndicator("화면3");

        tabHost.addTab(tabSpecOne, FragmentOne.class, null);
        tabHost.addTab(tabSpecTwo, FragmentTwo.class, null);
        tabHost.addTab(tabSpecThree, FragmentThree.class, null);

        tabHost.setCurrentTab(0);
    }

    protected void chageFragment(int no){
        tabHost.setCurrentTab(no);
    }
}
