package com.atongmu.snacktime.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.atongmu.snacktime.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticActivity extends AppCompatActivity {
    @BindView(R.id.webview) WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artic);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        webView.loadUrl(intent.getStringExtra("url"));
        //webView.getSettings().setJavaScriptEnabled(true);
    }
}
