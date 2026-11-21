package org.example;

import java.time.LocalDate;

public class Gasto{
    private final String descricao;
    private final LocalDate data;
    private final String categoria;
    private final double valor;

    public Gasto(String descricao, LocalDate data, String categoria, double valor){
        this.descricao = descricao;
        this.data = data;
        this.categoria = categoria;
        this.valor = valor;
    }

    public String getDescricao(){
        return descricao;
    }
    public LocalDate getData(){
        return data;
    }
    public String getCategoria(){
        return categoria;
    }
    public double getValor(){
        return valor;
    }
}