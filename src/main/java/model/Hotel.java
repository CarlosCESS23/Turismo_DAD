package model;

import java.io.Serializable;

public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idPacoteTuristico;
    private String cidade;
    private double valorDiaria;

    public Hotel(){}

    public Hotel(int idPacoteTuristico,String cidade, double valorDiaria) {
        this.idPacoteTuristico = idPacoteTuristico;
        this.cidade = cidade;
        this.valorDiaria = valorDiaria;
    }

    public int getIdPacoteTuristico() {
        return idPacoteTuristico;
    }

    public void setIdPacoteTuristico(int idPacoteTuristico) {
        this.idPacoteTuristico = idPacoteTuristico;
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
                "idPacoteTuristico=" + idPacoteTuristico +
                ", cidade='" + cidade + '\'' +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}