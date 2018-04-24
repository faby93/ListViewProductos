package com.example.talatec.listviewproductos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class AgregarActividad extends AppCompatActivity {
    Spinner spinner;
    EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        String categorias[]= {"Electronica","hogar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, categorias);
        spinner = (Spinner) findViewById(R.id.spnProducto);
        spinner.setAdapter(adapter);

        txtNombre = (EditText) findViewById(R.id.edtxtNombre);

    }

    public void agregar(View v){
        Intent i = new  Intent();
        i.putExtra("Nombre", txtNombre.getText().toString());
        i.putExtra("Categoria", spinner.getSelectedItem().toString());
        setResult(RESULT_OK,i);
        finish();

    }
}
