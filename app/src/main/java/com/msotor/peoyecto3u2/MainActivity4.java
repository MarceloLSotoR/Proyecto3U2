package com.msotor.peoyecto3u2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity4 extends AppCompatActivity {

    WebView wsv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        wsv1 =(WebView) findViewById(R.id.wv_01);

        String URL = getIntent().getStringExtra("sitioWeb");
        wsv1.setWebViewClient(new WebViewClient());
        wsv1.loadUrl("http://" + URL);
    }

    public void Cerrar (View view){
        finish();
    }
}