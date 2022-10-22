package com.msotor.peoyecto3u2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class base_de_datos extends AppCompatActivity {

    private EditText TextCod , TextNombre, TextPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_de_datos);

        TextCod = (EditText) findViewById(R.id.txt_codigo);
        TextNombre = (EditText) findViewById(R.id.txt_nombre);
        TextPrecio = (EditText) findViewById(R.id.txt_precio);
    }
    //Metodo para crear
    public void Crear(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();//Este metodo funciona para poder habrir el modo de lectura y escritura en la base de datos de SQLite

        String Codigo = TextCod.getText().toString();
        String Nombre = TextNombre.getText().toString();
        String Precio = TextPrecio.getText().toString();

        if(!Codigo.isEmpty() && !Nombre.isEmpty() && !Precio.isEmpty()){
            
            ContentValues registro = new ContentValues();

            registro.put("Codigo",Codigo);
            registro.put("Nombre",Nombre);
            registro.put("Precio",Precio);

            BaseDeDatos.insert("articulos", null, registro);
            BaseDeDatos.close();

            TextCod.setText("");
            TextNombre.setText("");
            TextPrecio.setText("");

            Toast.makeText(this, "El regsitro fue exitoso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para Buscar un Producto
    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Codigo = TextCod.getText().toString();

        if (!Codigo.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery
                    ("select nombre, precio from articulos where codigo ="+ Codigo, null);

            if(fila.moveToFirst()){
                TextNombre.setText(fila.getString(0));
                TextPrecio.setText(fila.getString(1));
                BaseDeDatos.close();
            }else{
                Toast.makeText(this, "El producto no existe", Toast.LENGTH_SHORT).show();
                BaseDeDatos.close();
            }

        }else{
            Toast.makeText(this, "Debes introducir e codigo del producto", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para eliminar un producto
    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Codigo = TextCod.getText().toString();

        if(!Codigo.isEmpty()){

            int cantidad = BaseDeDatos.delete("articulos","codigo="+ Codigo, null);
            BaseDeDatos.close();

            TextCod.setText("");
            TextNombre.setText("");
            TextPrecio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "El articulo fue eliminado con exito", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debes introducir e codigo del producto", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para modificar un producto
    public void Modificar(View view ){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Codigo = TextCod.getText().toString();
        String Nombre = TextNombre.getText().toString();
        String Precio = TextPrecio.getText().toString();

        if (!Codigo.isEmpty() && !Nombre.isEmpty() && !Precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo", Codigo);
            registro.put("nombre", Nombre);
            registro.put("precio", Precio);

            int cantidad = BaseDeDatos.update("articulos", registro,"codigo="+ Codigo, null);
            BaseDeDatos.close();

            if(cantidad == 1){
                Toast.makeText(this, "El articulo fue Modificado con exito", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}