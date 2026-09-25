package PastaYasmim.pacote.teste;



import PastaYasmim.pacote.model.Pacote;
import PastaYasmim.pacote.service.PacoteTurismoService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TestaPacoteTurismoService {

    public static void main(String[] args) throws NotBoundException, RemoteException {

        PacoteTurismoService pacoteTurismoService= new PacoteTurismoService();
        Pacote pacote= pacoteTurismoService.montarPacote("MAO","BEL");
        System.out.println("----------RECIBO----------");
        System.out.println("ORIGEM: "+pacote.getOrigem()+"\n"+
                "DESTINO: "+pacote.getDestino());
        System.out.println("--------------------------");
        pacote.listarItens();
        System.out.println("--------------------------");
        System.out.println("TOTAL: "+pacote.getTotal());
    }
}
