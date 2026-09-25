package servidor.service;

import servidor.model.Item;
import servidor.model.Pacote;
import servidor.repository.IRepository;
import servidor.tipos.TipoItem;

import java.util.Collections;
import java.util.List;
public class PacoteService implements IPacoteService{
    IRepository<Pacote> repository;

    public PacoteService(IRepository<Pacote> repository){
        this.repository = repository;
    }

    public Pacote montarPacote(String origem,String destino,Item aluguel,Item passagem,Item hotel,Item seguroViagem,Item carro) {
        Pacote pacote = new Pacote(origem,destino);
        pacote.adicionarItem(passagem);
        pacote.adicionarItem(hotel);
        pacote.adicionarItem(seguroViagem);
        pacote.adicionarItem(carro);
        return pacote;
    }

    @Override
    public List<Item> buscarTipo(TipoItem tipo) {
        return null;
    }

    public Pacote buscarPacote(String origem, String destino) {
//        return montarPacote();
        return null;
    }

    public List<Pacote> listarPacote() {
        return Collections.emptyList();
    }

    public void addPacote(Pacote pacote) {


    }

    public void rmPacote(Pacote pacote) {

    }

    @Override
    public List<Item> buscarPorOrigemDestino(String origem, String destino) {
        return null;
    }
}
