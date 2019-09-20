package com.example.meusgastov2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private DespesasDAO dao;
    private List<Despesa> desp;
    private List<Despesa> despFiltrados = new ArrayList<>();

    Button btnAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listDespesas);
        dao = new DespesasDAO(this);
        desp = dao.obterTodos();
        despFiltrados.addAll(desp);

        //para usar o listview é preciso criar um adapter ou usar um pronto do java, vou suar a 2º op;

        ArrayAdapter<Despesa> adaptador = new ArrayAdapter<Despesa>(this,android.R.layout.simple_list_item_1, despFiltrados);
        listView.setAdapter(adaptador);
    }

    public boolean onCreateOptionsMenu (Menu menu){

        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.manu_principal, menu);
        return true;
    }

    public void cadastrar (MenuItem item){

        Intent it = new Intent(MainActivity.this, Despesa_form.class);
        startActivity(it);

    }

    @Override
    public void onResume(){
        super.onResume();
        desp= dao.obterTodos();
        despFiltrados.clear();
        despFiltrados.addAll(desp);
        listView.invalidateViews();
    }

}
