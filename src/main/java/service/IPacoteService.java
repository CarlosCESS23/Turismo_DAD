package service;

import model.Item;
import model.Pacote;
import tipos.TipoItem;

import java.util.List;

public interface IPacoteService {
    public Pacote buscarPacote();
    public List<Pacote> listarPacote();
    public void addPacote(Pacote pacote);
    public void rmPacote(Pacote pacote);
    public Pacote montarPacote();
    public List<Item> buscarTipo(TipoItem tipo);


}
