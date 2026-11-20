package org.example;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ItemFixo{
    private final String descricao;
    private final int dia;
    private final double valor;
    private final BooleanProperty pago = new SimpleBooleanProperty(false);

    public ItemFixo(String descricao, int dia, double valor){
        this.descricao = descricao;
        this.dia = dia;
        this.valor = valor;
    }

    public String getDescricao(){
        return descricao;
    }
    public int getDia(){
        return dia;
    }
    public double getValor(){
        return valor;
    }

    public BooleanProperty pagoProperty(){
        return pago;
    }
    public boolean isPago(){
        return pago.get();
    }
}
