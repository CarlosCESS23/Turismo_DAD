package model;

import java.io.Serializable;

public class PassagemAerea implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String origem = "Manaus (MAO)";

    public String destino;

    public double preco;

    public PassagemAerea(String origem, String destino, double preco) {
        PassagemAerea.origem = origem;
        this.destino = destino;
        this.preco = preco;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        PassagemAerea.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Origem= " + origem +
                "\nDestino= " + destino +
                "\nPreco= " + String.format("%.2f", preco) ;
    }
}