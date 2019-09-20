package com.example.meusgastov2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Despesa_form extends AppCompatActivity {

    EditText edtNome;
    EditText edtValor;
    EditText edtCategoria;
    Button btnConfirma;
    private DespesasDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesa_form);


        edtNome = findViewById(R.id.edtNome);
        edtValor = findViewById(R.id.edtValor);
        edtCategoria = findViewById(R.id.edtCategoria);
        btnConfirma = findViewById(R.id.btnConfirma);
        dao = new DespesasDAO(this);

        }

        public void salvar (View v){

        Despesa d = new Despesa();

        d.setNome(edtNome.getText().toString());
        d.setValor(Integer.valueOf(edtValor.getText().toString()));
        d.setCategoria(edtCategoria.getText().toString());
        long id = dao.inserir(d);
        Toast.makeText(this,"Despesa  "+ edtNome.getText().toString() +" inserida com sucesso!", Toast.LENGTH_LONG).show();
        }
}
