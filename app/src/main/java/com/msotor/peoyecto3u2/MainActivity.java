package com.msotor.peoyecto3u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText et0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et0=(EditText)findViewById(R.id.txt_Email);

        SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        et0.setText(preferences.getString("mail",""));
    }
    public void Guardar (View view){
        SharedPreferences preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =preferencias.edit();
        editor.putString("mail",et0.getText().toString());
        editor.commit();
        finish();
    }
}