package com.msotor.peoyecto3u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Boton_BD (View view) {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
    public void Boton_Persistente(View view) {
        Intent i = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(i);
    }

}
