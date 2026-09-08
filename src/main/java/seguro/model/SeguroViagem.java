package seguro.model;

import  java.io.Serializable;


// Classe que representa um seguro viagem.
public class SeguroViagem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String estado;
    private double diaria;


    public SeguroViagem(String estado, double diaria) {
        this.estado = estado;
        this.diaria = diaria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    @Override
    public String toString() {
        return "Estado: " + estado +
                "\nDiária: R$ " +
                String.format("%.2f", diaria);
    }

}
