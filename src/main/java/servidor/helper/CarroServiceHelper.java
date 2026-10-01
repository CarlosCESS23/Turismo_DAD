package servidor.helper;


import model.LocalAluguel;
import rmi.IAluguelService;
import servidor.model.Item;
import servidor.utils.ItemServico;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CarroServiceHelper {

    public Item consultarCarro(String destino) throws RemoteException, NotBoundException {
        String host = "10.100.32.85";
        int porta = 1001;

        Registry registro = LocateRegistry.getRegistry(host, porta);

        IAluguelService aluguelService = (IAluguelService) registro.lookup("rmi://10.100.32.85:1001/aluguel");

        LocalAluguel carroOrigem = aluguelService.getLocalPorNome(destino);

        Item item = new Item();
        item.setTipo(ItemServico.CARRO);
        item.setValor(carroOrigem.getValorDiaria());

        return item;
    }

}
