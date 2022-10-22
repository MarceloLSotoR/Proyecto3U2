package com.msotor.peoyecto3u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_email);

        SharedPreferences preferences  = getSharedPreferences("datos", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("mail",""));
    }

    public void Guardar(View view) {
        SharedPreferences preferencias  = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();
        Obj_editor.putString("mail", et1.getText().toString());
        Obj_editor.commit();
        finish();
    }
}