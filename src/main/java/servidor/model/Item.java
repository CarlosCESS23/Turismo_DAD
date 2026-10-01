package servidor.model;


import servidor.utils.ItemServico;

import java.io.Serializable;

public class Item implements Serializable {
    private final long serialVersionUID = 1l;
    private double valor;
    private ItemServico tipo;

    public Item(double valor, ItemServico tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public Item() {

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ItemServico getTipo() {
        return tipo;
    }

    public void setTipo(ItemServico tipo) {
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