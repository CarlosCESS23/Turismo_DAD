package PastaYasmim.pacote.app;

import PastaYasmim.pacote.ennum.ItemServico;
import PastaYasmim.pacote.model.Item;
import PastaYasmim.pacote.model.Pacote;
import PastaYasmim.pacote.service.PacoteTurismoService;

public class Main {

    public static void main(String[] args) {

        Pacote pacote= new Pacote("MAO","FOR",2);

        Item passagem= new Item(ItemServico.AEREO, 1500);
        Item hotel= new Item(ItemServico.HOTEL, 3600);
        Item hotel2= new Item(ItemServico.HOTEL, 1000);
        Item seguro= new Item(ItemServico.SEGURO, 2500);
        Item carro= new Item(ItemServico.CARRO, 3000);

        pacote.adicionarItens(passagem);
        pacote.adicionarItens(hotel);
        pacote.adicionarItens(hotel2);
        pacote.adicionarItens(seguro);
        pacote.adicionarItens(carro);


        System.out.println(pacote.getTotal());

    }

}
