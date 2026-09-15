package servidor;

import service.HotelServiceImpl;
import service.IHotelService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRegistro {

    public static void main(String[] args) {
        try {
            IHotelService hotelService = new HotelServiceImpl();

            String host = "localhost";
            int porta = 1000;

            Registry registro = LocateRegistry.createRegistry(porta);

            registro.rebind(
                    "rmi://" + host + ":" + porta + "/hotel",
                    hotelService
            );

            System.out.println("Servidor de hotel rodando!");

        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        }
    }
}