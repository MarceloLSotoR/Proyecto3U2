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

    public void boton_check(View view) {
        Intent i = new Intent(MainActivity.this, MainBD.class);
        startActivity(i);
    }

    public void boton_check2(View view) {
        Intent i = new Intent(MainActivity.this, MainValidacion.class);
        startActivity(i);
    }

    public void boton_check3(View view) {
        Intent i = new Intent(MainActivity.this, MainSharedPreferences.class);
        startActivity(i);
    }


}