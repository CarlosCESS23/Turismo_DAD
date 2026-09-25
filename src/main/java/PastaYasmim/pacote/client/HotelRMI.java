//package turismo.pacote.client;
//
//import model.Hotel;
//import service.IHotelService;
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class HotelRMI {
//    public static void main(String[] args) throws RemoteException, NotBoundException {
//        String host = "10.100.32.79";
//        int porta = 2012;
//
//        Registry registro = LocateRegistry.getRegistry(host,porta);
//
//        String[] listaCatalogo = registro.list();
//
//        for (String item : listaCatalogo){
//            System.out.println(item);
//        }
//
//         IHotelService hotelService = (IHotelService) registro.lookup("rmi://10.100.32.79:2012/hotel");
//
//        for(Hotel viagem : hotelService.getLista()){
//            System.out.println(viagem);
//        }
//
//        hotelService.
//
//    }
//}
