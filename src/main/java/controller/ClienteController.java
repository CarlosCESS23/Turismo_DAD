package controller;

import service.IPacoteService;
import service.PacoteService;
import tipos.TipoItem;

public class ClienteController {
    static final IPacoteService service = new PacoteService();

    public static void main(String[] args) {
//        montarPacote();
//        listarPacote();
//        buscarPacote();
        listarItem(TipoItem.PASSAGEM);
    }

    static void montarPacote(){
        System.out.println(service.montarPacote());
    }

    static void listarPacote(){
        System.out.println(service.listarPacote());
    }
    static void buscarPacote(){
        System.out.print(service.buscarPacote());
    }
    static void listarItem(TipoItem item){
        System.out.println(service.buscarTipo(item));
    }
}
