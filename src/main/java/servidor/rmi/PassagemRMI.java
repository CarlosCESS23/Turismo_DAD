package servidor.rmi;

import utils.IPassagemAerea;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PassagemRMI {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        String host = "192.168.15.74";
        int porta = 2011;

        Registry registro = LocateRegistry.getRegistry(host, porta);

        String[] listaCatalogo = registro.list();

        for (String item : listaCatalogo) {
            System.out.println(item);
        }

        IPassagemAerea passagemAerea = (IPassagemAerea) registro.lookup("rmi://" + host + ":" + porta + "/passagemAerea");

        System.out.println(passagemAerea.buscarPassagemAerea("BEL"));

    }
}
