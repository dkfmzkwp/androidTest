package com.example.tabhostproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

@SuppressWarnings("deprecation")
//주의할것 extends AppCompatActivity 대신 TabActivity
public class MainActivity extends TabActivity {
    //여기서 불러올것이 없음.
    private TabHost tabHost;
    private TabHost.TabSpec tabSpecSong;
    private TabHost.TabSpec tabSpecArtist;
    private TabHost.TabSpec tabSpecAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TabHost findViewById -> getTabHost();
        tabHost = getTabHost();

        //tabWidget에 버튼을 넣는 방법
        //tag = 대문자
        tabSpecSong = tabHost.newTabSpec("SONG").setIndicator("음악별");
        tabSpecArtist = tabHost.newTabSpec("ARTIST").setIndicator("가수별");
        tabSpecAlbum = tabHost.newTabSpec("ALBUM").setIndicator("앨범별");
        //음악별 버튼을 누르면 tabsong layout이 선택된다.
        tabSpecSong.setContent(R.id.tabSong);
        tabSpecArtist.setContent(R.id.tabArtist);
        tabSpecAlbum.setContent(R.id.tabAlbum);
        //Tabhost tabwidget 메뉴버튼 삽입
        tabHost.addTab(tabSpecSong);
        tabHost.addTab(tabSpecArtist);
        tabHost.addTab(tabSpecAlbum);

        tabHost.setCurrentTab(0);
    }
}
