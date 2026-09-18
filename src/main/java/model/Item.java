package model;

import tipos.TipoItem;


public class Item {
    private double valor;
    private TipoItem tipo;

    public Item(double valor, TipoItem tipo){
        this.valor = valor;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nItem{" +
                "tipo=" + tipo +
                ", valor=" + valor +
                '}';
    }
}