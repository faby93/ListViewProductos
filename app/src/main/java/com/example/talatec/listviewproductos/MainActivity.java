package com.example.talatec.listviewproductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //variables a declarar
    private TextView txt; private
    ListView lista;
    //Datos con los que se llenara el ListView
    private List<String> lProductos = new ArrayList<>();
    private List<String> lcategoria = new ArrayList<>();

    //private String productos[] = {"Computadora", "Mouse", "Dulces", "Hojas", "Lapices", "Lentes","Reloj", "Cuchara", "Celular", "Mesa", "Refrigerador", "Horno", "Audifonos"};
    //private String categoria[] = {"Electronica","Electronica","Dulceria","Papeleria","Papeleria","Moda","Perfumeria ", "Hogar", "Electronicos", "Hogar", "Electrodomesticos", "Electrodomesticos", "Electronica"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textView);
        lista = (ListView) findViewById(R.id.lista);

        actualizarTabla();
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText("Categoria elegido: " + categoria[position]);
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lProductos.add(data.getStringExtra("Nombre"));
        lcategoria.add(data.getStringExtra("Categoria"));
        Toast.makeText(this, "Producto : "+data.getStringExtra("Nombre")+" agegado!", Toast.LENGTH_LONG).show();
        actualizarTabla();
    }

    private void actualizarTabla(){
        String productos[] = new String[lProductos.size()];
        lProductos.toArray(productos);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,productos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                txt.setText("categoria elegido: " + lcategoria.get(position));
            }
        });

    }
    public void llamaActividad(View x) {
        Intent i = new Intent(this,AgregarActividad.class);
        startActivityForResult(i,123);
    }
}

