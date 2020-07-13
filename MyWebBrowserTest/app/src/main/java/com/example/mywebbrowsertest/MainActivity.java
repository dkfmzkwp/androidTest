package com.example.mywebbrowsertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etUrl;
    private Button btnGo;
    private Button btnBack;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = (EditText)findViewById(R.id.etUrl);
        btnGo = (Button)findViewById(R.id.btnGo);
        btnBack = (Button)findViewById(R.id.btnBack);
        webView = (WebView)findViewById(R.id.webView);

        //2.webView -> MyWebViewClient 등록시켜야한다.
        webView.setWebViewClient(new MyWebViewClient());

        //3. webView 셋팅하는데 줌 아이콘을 사용할 수 있도록 설정
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("http://"+etUrl.getText().toString());
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.goBack();
            }
        });
        //마지막으로 AndroidManifest에서 인터넷 permission을 받아야 인터넷 사용가능하다
    }

    //1.내부클래스(인스턴스멤버 내부클래스, 정적멤버 내부클래스, 지역클래스)
    class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
