package service;

import model.Item;
import model.Pacote;
import tipos.TipoItem;

import java.util.Collections;
import java.util.List;
public class PacoteService implements IPacoteService{

    public Pacote montarPacote() {
        Pacote pacote = new Pacote("MAO","FOR");
        Item seguroViagem = new Item(20.5, TipoItem.SEGURO);
        Item hotel = new Item(300.2,TipoItem.HOTEL);
        Item passagem = new Item(2500,TipoItem.PASSAGEM);
        Item carro = new Item(300, TipoItem.CARRO);
        Item seguroViagem2 = new Item(30.4,TipoItem.SEGURO);

        pacote.adicionarItem(seguroViagem);
        pacote.adicionarItem(hotel);
        pacote.adicionarItem(passagem);
        pacote.adicionarItem(carro);
        pacote.adicionarItem(seguroViagem2);


        return pacote;
    }

    @Override
    public List<Item> buscarTipo(TipoItem tipo) {
        Pacote pacote = montarPacote();

        return pacote.ListarTipos(tipo);
    }

    public Pacote buscarPacote() {
        return montarPacote();
    }

    public List<Pacote> listarPacote() {
        return Collections.emptyList();
    }

    public void addPacote(Pacote pacote) {

    }

    public void rmPacote(Pacote pacote) {

    }
}
