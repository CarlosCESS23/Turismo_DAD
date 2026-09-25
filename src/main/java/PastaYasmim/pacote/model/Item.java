package PastaYasmim.pacote.model;


import PastaYasmim.pacote.ennum.ItemServico;

public class Item {

    private ItemServico tipo;
    private double valor;

    public Item(){

    }

    public Item(ItemServico tipo, double valor){
        this.tipo= tipo;
        this.valor=valor;
    }

    public ItemServico getTipo() {
        return tipo;
    }

    public void setTipo(ItemServico tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
