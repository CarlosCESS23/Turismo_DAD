package servidor.model;

import servidor.tipos.TipoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pacote {
    private String origem;
    private String destino;
    private List<Item> itens;
    private double valorTotal;

    public Pacote(){
        itens = new ArrayList<Item>();
    }

    public Pacote(String origem,String destino){
        this.itens = new ArrayList<>();
        this.destino = destino;
        this.origem = origem;
    }

    public List<Item> getListasItens() {
        return itens;
    }

    public void setListasItens(List<Item> itens) {
        this.itens = itens;
    }

    public void adicionarItem(Item item){
        this.itens.add(item);
    }

    public void removerItem(Item item){
        this.itens.remove(item);
    }

    public double getValorTotal(){
        double valorTotal = this.itens.stream()
                .mapToDouble(Item::getValor).sum();
        return valorTotal;
    }

    public List<Item> ListarTipos(TipoItem tipo){
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
    @Override
    public String toString() {
        return "\nPacote{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ",\n itens=" + itens +
                ",\n valorTotal=" + getValorTotal() +
                '}';
    }
}
