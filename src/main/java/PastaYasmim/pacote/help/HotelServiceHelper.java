//package turismo.pacote.help;
//
//import model.Hotel;
//import service.IHotelService;
//import turismo.pacote.model.Item;
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class HotelServiceHelper {
//
//    public Item ConsultarHotel(String destino) throws RemoteException, NotBoundException {
//
//        String host = "10.100.32.79";
//        int porta = 2012;
//
//        Registry registro = LocateRegistry.getRegistry(host,porta);
//
//        IHotelService hotelService = (IHotelService) registro.lookup("rmi://10.100.32.79:2012/hotel");
//
//        for(Hotel viagem : hotelService.getLista()){
//            System.out.println(viagem);
//        }
//    }
//}
