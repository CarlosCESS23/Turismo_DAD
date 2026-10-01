package servidor.model;

import servidor.utils.ItemServico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pacote implements Serializable {
    private final long serialVersionUID = 1l;
    private long idPacote;
    private String origem;
    private String destino;
    private List<Item> itens;
    private int pessoa;
    private double valorTotal;



    public Pacote(int idPacote, String origem, String destino, int pessoa) {
        this.idPacote = idPacote;
        this.itens = new ArrayList<>();
        this.destino = destino;
        this.origem = origem;
        this.pessoa = pessoa;
    }

    public List<Item> ListarTipos(ItemServico tipo) {
        List<Item> listaSelecionado = this.itens.stream()
                .filter(lista -> lista.getTipo() == tipo)
                .collect(Collectors.toList());

        return listaSelecionado;
    }

    public void aplicarDesconto(){
         if(this.valorTotal > 5000 && this.valorTotal < 7000){
             this.valorTotal = this.valorTotal - (this.valorTotal * 0.10);
             return;
         }
         if(this.valorTotal > 7000){
             this.valorTotal = this.valorTotal - (this.valorTotal * 0.20);
             return;
         }
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public void removerItem(Item item) {
        this.itens.remove(item);
    }

    public List<Item> getListasItens() {
        return itens;
    }

    public int getPessoa() {
        return pessoa;
    }

    public void setPessoa(int pessoa) {
        this.pessoa = pessoa;
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

    public double getValorTotal() {
        double valorTotal = this.itens.stream()
                .mapToDouble(Item::getValor).sum();
        return valorTotal;
    }

    public long getIdPacote() {
        return idPacote;
    }

    @Override
    public String toString() {
        return "\nPacote{" +
                "\nidPacote=" + idPacote +
                "\n, origem='" + origem + '\'' +
                "\n, destino='" + destino + '\'' +
                "\n, itens=" + itens +
                "\n, pessoa=" + pessoa +
                "\n, valorTotal=" + valorTotal +
                "}";
    }
}
