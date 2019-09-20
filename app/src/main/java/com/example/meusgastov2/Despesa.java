package com.example.meusgastov2;

import java.io.Serializable;

public class Despesa implements Serializable {

    private Integer id;
    private String nome;
    private Integer valor;
    private String categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;

    }

    public String toString(){
        return nome;

    }
}

