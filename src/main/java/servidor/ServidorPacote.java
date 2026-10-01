package servidor;

import servidor.service.IPacoteService;
import servidor.service.PacoteService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorPacote {
    public static void main(String[] args) throws RemoteException {

        IPacoteService pacoteService = new PacoteService();
        try{
            String host = "192.168.15.66";
            int porta = 2013;

            Registry registro = LocateRegistry.createRegistry(porta);

            registro.rebind(
                    "rmi//"+host+":" +porta+ "/pacote" ,pacoteService
            );

            System.out.println("Servidor rodando!!!!");

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}

