package com.msotor.peoyecto3u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {

    private EditText edt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        edt1 = (EditText) findViewById(R.id.txt_pagina);
    }

    public void Navegacion(View view){
        Intent i = new Intent(this, MainActivity4.class);
        i.putExtra("sitioWeb", edt1.getText().toString());
        startActivity(i);
    }
}