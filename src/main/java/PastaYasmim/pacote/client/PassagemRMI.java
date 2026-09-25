//package PastaYasmim.pacote.client;
//
//import model.PassagemAerea;
//import model.SeguroViagem;
//import rmi.ISeguroViagemService;
//import utils.IPassagemAerea;
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class PassagemRMI {
//    public static void main(String[] args) throws RemoteException, NotBoundException {
//        String host = "10.100.32.169";
//        int porta = 2000;
//
//        Registry registro = LocateRegistry.getRegistry(host,porta);
//
//        String[] listaCatalogo = registro.list();
//
//        for (String item : listaCatalogo){
//            System.out.println(item);
//        }
//
//       IPassagemAerea passagemAerea = (IPassagemAerea) registro.lookup("rmi://10.100.32.169:2000/passagemAerea");
//
//      System.out.println(passagemAerea.buscarPassagemAerea("BEL"));
//
//    }
//}
