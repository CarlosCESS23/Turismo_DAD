package model;

import java.math.BigDecimal;

public class Hotel {
    private long ID;
    private String local;
    private String estado;
    private BigDecimal preco;

    public Hotel() {

    }

    public Hotel(String local, String estado, String preco,long ID) {
        this.ID = ID;
        this.local = local;
        this.estado = estado;
        this.preco = new BigDecimal(preco);
    }

    public long getID() {
        return ID;
    }
    public void setID(long ID){
        this.ID = ID;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\nHotel{" +
                "\n ID=" + ID +
                ",\n local='" + local + '\'' +
                ",\n estado='" + estado + '\'' +
                ",\n preco=" + preco +
                "\n}\n";
    }
}
