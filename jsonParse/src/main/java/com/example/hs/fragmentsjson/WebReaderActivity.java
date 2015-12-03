package com.example.hs.fragmentsjson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebReaderActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        webView = (WebView)findViewById(R.id.webView);
        Intent intent = getIntent();
        String link =intent.getStringExtra("link");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(link);
    }
}
