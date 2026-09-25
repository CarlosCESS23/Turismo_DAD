package servidor.service;

import servidor.model.Item;
import servidor.model.Pacote;
import servidor.tipos.TipoItem;

import java.util.List;

public interface IPacoteService {
    public Pacote buscarPacote(String origem, String destino);
    public List<Pacote> listarPacote();
    public void addPacote(Pacote pacote);
    public void rmPacote(Pacote pacote);
    public Pacote montarPacote(String origem,String Destino,Item aluguel,Item passagem,Item hotel,Item seguroViagem,Item carro);
    public List<Item> buscarTipo(TipoItem tipo);
    public List<Item> buscarPorOrigemDestino(String origem, String destino);


}
