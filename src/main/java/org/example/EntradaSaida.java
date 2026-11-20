package org.example;

public class EntradaSaida{
    private final String descricao;
    private final String tipo;
    private final double valor;

    public EntradaSaida(String descricao, String tipo, double valor){
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getDescricao(){
        return descricao;
    }
    public String getTipo(){
        return tipo;
    }
    public double getValor(){
        return valor;
    }
}
