//package PastaYasmim.pacote.client;
//
//
//import model.LocalAluguel;
//import rmi.IAluguelService;
//import turismo.pacote.ennum.ItemServico;
//import turismo.pacote.model.Item;
//import turismo.pacote.model.Pacote;
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class CarroRMI {
//    public static void main(String[] args) throws RemoteException, NotBoundException {
//        String host = "10.100.32.85";
//        int porta = 1001;
//
//        Registry registro = LocateRegistry.getRegistry(host,porta);
//
//        String[] listaCatalogo = registro.list();
//
//        for (String item : listaCatalogo){
//            System.out.println(item);
//        }
//
//        IAluguelService aluguelService = (IAluguelService) registro.lookup("rmi://10.100.32.85:1001/aluguel");
//
//        LocalAluguel carroOrigem = aluguelService.getLocalPorNome("BEL");
//
//
//        Pacote pacote= new Pacote();
//        Item item = new Item();
//        item.setTipo(ItemServico.CARRO);
//        item.setValor(carroOrigem.getValorDiaria());
//        pacote.adicionarItens(item);
//
//        System.out.println(pacote.getTotal());
//
//    }
//}
