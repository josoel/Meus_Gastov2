package com.example.meusgastov2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DespesasDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public DespesasDAO (Context context){

        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();

    }

    public long inserir (Despesa despesa) {
        ContentValues v = new ContentValues();
        v.put("nome", despesa.getNome());
        int valor = Integer.valueOf(despesa.getValor().toString());
        v.put("valor", valor);
        v.put("categoria", despesa.getCategoria());
        return banco.insert("tb_despesas",null, v);
    }

    public List<Despesa> obterTodos(){
        List<Despesa> desp = new ArrayList<>();
        Cursor cursor =  banco.query("tb_despesas",new String[]{"id","nome","valor","categoria"},null,null,null,null,null);
        while (cursor.moveToNext()){
            Despesa a = new Despesa();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setValor(cursor.getInt(2));
            a.setCategoria(cursor.getString(3));
            desp.add(a);
        }
        return desp;
    }


}
