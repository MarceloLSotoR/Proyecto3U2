package com.msotor.peoyecto3u2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainValidacion extends AppCompatActivity {

    private EditText etn, etp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_validacion);

        etn = (EditText)findViewById(R.id.txt_nombre);
        etp = (EditText)findViewById(R.id.txt_password);
    }


    public void Registrar(View view){

        String nombre = etn.getText().toString();
        String passward = etp.getText().toString();

        if(nombre.length() == 0){
            Toast.makeText(this, "Debes de ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        if(passward.length() == 0){
            Toast.makeText(this, "Debes de ingresar una password", Toast.LENGTH_LONG).show();
        }
        if(nombre.length() != 0 && passward.length() != 0){
            Toast.makeText(this, "Registro en proceso...", Toast.LENGTH_LONG).show();
        }
    }
}