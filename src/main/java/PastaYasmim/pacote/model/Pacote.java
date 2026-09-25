package PastaYasmim.pacote.model;

import java.util.ArrayList;
import java.util.List;

public class Pacote {

    private long idPacote
    private String origem;
    private String destino;
    private int pessoa;
    private List<Item> itens= new ArrayList<>();
    private double valorTotal;

    public Pacote(){

    }

    public Pacote(int idPacote,String origem, String destino, int pessoa){
        this.origem= origem;
        this.destino= destino;
        this.pessoa= pessoa;
        this.idPacote = idPacote;
    }

    public void adicionarItens(Item item){
        itens.add(item);
    }

    public Double getTotal(){
        valorTotal = itens.stream()
                .mapToDouble(Item::getValor)
                .sum();

        return valorTotal;
    }

    public long getIdPacote() {
        return idPacote;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getPessoa() {
        return pessoa;
    }

    public void setPessoa(int pessoa) {
        this.pessoa = pessoa;
    }

    public void listarItens(){
        for(Item item : itens){
            System.out.println("Tipo: "+ item.getTipo() + " | Valor: "+ item.getValor());
        }
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", Valor total=" + getTotal() +
                '}';
    }
}
