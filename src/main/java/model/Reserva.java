package model;

import java.io.Serializable;

public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idPacote;
    private String cpfCliente;
    private String destino;

    public Reserva(String idPacote, String cpfCliente, String destino) {
        this.idPacote = idPacote;
        this.cpfCliente = cpfCliente;
        this.destino = destino;
    }

    public String getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(String idPacote) {
        this.idPacote = idPacote;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Reserva [Pacote=" + idPacote + ", CPF=" + cpfCliente + ", Destino=" + destino + "]";
    }
}
