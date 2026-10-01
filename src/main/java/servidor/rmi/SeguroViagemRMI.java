package servidor.rmi;


import seguro.ISeguroViagemService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SeguroViagemRMI implements IConexao<ISeguroViagemService> {

    // Responsabilidade de fazer a conexão com o SeguroViagemRMI
    public ISeguroViagemService getConexao() throws RemoteException, NotBoundException {
        String host = "192.168.15.74";
        int porta = 2009;

        Registry registro = LocateRegistry.getRegistry(host, porta);

        String[] listaCatalogo = registro.list();

        for (String item : listaCatalogo) {
            System.out.println(item);
        }

        ISeguroViagemService seguroViagemService = (ISeguroViagemService) registro.lookup("rmi://192.168.15.74:2009/seguroViagem");

        return seguroViagemService;
    }

}
