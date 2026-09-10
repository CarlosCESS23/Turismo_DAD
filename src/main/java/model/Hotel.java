package model;

import java.io.Serializable;

public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String cidade;
    private double valorDiaria;

    public Hotel(){}

    public Hotel(String cidade, double valorDiaria) {
        this.cidade = cidade;
        this.valorDiaria = valorDiaria;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "cidade='" + cidade + '\'' +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}