package servidor.controller;

import servidor.model.Item;
import servidor.model.Pacote;
import servidor.repository.IRepository;
import servidor.repository.PacoteRepository;
import servidor.service.IPacoteService;
import servidor.service.PacoteService;
import servidor.tipos.TipoItem;

public class PacoteController {
    static IRepository<Pacote> Repository = new PacoteRepository();
    static IPacoteService service = new PacoteService(Repository);

    public static void main(String[] args) {
        montarPacote();
    }

    static void montarPacote(){
        String origem, destino;
        origem = "MAO";
        destino = "FOR";
        Item hotel = new Item(452.50,TipoItem.HOTEL);
        Item carro = new Item(149.90,TipoItem.CARRO);
        Item seguro = new Item(139.34,TipoItem.SEGURO);
        Item passagem = new Item(4000.99,TipoItem.PASSAGEM);

        System.out.println(service.montarPacote(origem,destino,carro,passagem,hotel,seguro,carro));
    }

    static void listarPacote(){

    }
    static void buscarPacote(){

    }
    static void listarItem(TipoItem item){

    }
}
