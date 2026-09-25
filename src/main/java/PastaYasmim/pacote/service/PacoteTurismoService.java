package PastaYasmim.pacote.service;


import PastaYasmim.pacote.model.Pacote;
import PastaYasmim.pacote.service.interfaces.IPacoteTurismoService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PacoteTurismoService implements IPacoteTurismoService {


    public Pacote montarPacote(String origem, String destino) throws NotBoundException, RemoteException {

        Pacote pacote = new Pacote();
        pacote.setOrigem(origem);
        pacote.setDestino(destino);

//        CarroServiceHelper carroServiceHelper= new CarroServiceHelper();
//        SeguroServiceHelper seguroServiceHelper= new SeguroServiceHelper();
//
//        Item item1= carroServiceHelper.consultarCarro(pacote.getDestino());
//        Item item2= seguroServiceHelper.consultarSeguroViagem(pacote.getDestino());
//
//        pacote.adicionarItens(item1);
//        pacote.adicionarItens(item2);

        return pacote;
    }

}
