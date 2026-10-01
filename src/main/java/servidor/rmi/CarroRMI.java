//package servidor.rmi;
//
//import model.LocalAluguel;
//import rmi.IAluguelService;
//import servidor.model.Item;
//import servidor.model.Pacote;
//import servidor.utils.ItemServico;
//
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class CarroRMI {
//    public static void main(String[] args) throws RemoteException, NotBoundException {
//        String host = "192.168.15.74";
//        int porta = 2010;
//
//        Registry registro = LocateRegistry.getRegistry(host, porta);
//
//        String[] listaCatalogo = registro.list();
//
//        for (String item : listaCatalogo) {
//            System.out.println(item);
//        }
//
//        IAluguelService aluguelService = (IAluguelService) registro.lookup("rmi://" + host + ":" + porta + "/aluguel");
//
//        LocalAluguel carroOrigem = aluguelService.getLocalPorNome("BEL");
//
//
////        Pacote pacote = new Pacote(, "Pará", 1, 2);
//        Item item = new Item();
//        item.setTipo(ItemServico.CARRO);
//        item.setValor(carroOrigem.getValorDiaria());
//        pacote.adicionarItem(item);
//
//        System.out.println(pacote.getValorTotal());
//
//    }
//}
