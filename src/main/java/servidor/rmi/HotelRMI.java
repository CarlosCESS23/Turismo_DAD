package servidor.rmi;

import service.IHotelService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HotelRMI implements IConexao<IHotelService> {

    @Override
    public IHotelService getConexao() throws RemoteException, NotBoundException {
        String host = "192.168.15.74";
        int porta = 2010;

        Registry registro = LocateRegistry.getRegistry(host, porta);

        String[] listaCatalogo = registro.list();

        for (String item : listaCatalogo) {
            System.out.println(item);
        }

        IHotelService hotelService = (IHotelService) registro.lookup("rmi://" + host + ":" + porta + "/hotel");

        return hotelService;
    }
}
