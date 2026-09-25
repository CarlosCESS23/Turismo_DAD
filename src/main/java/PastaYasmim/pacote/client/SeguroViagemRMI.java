//package PastaYasmim.pacote.client;
//
//import rmi.ISeguroViagemService;
//import model.SeguroViagem;
//import turismo.pacote.ennum.ItemServico;
//import turismo.pacote.model.Item;
//import turismo.pacote.model.Pacote;
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class SeguroViagemRMI {
//
//    public static void main(String[] args) throws RemoteException, NotBoundException {
//        String host = "10.100.32.89";
//        int porta = 1099;
//
//        Registry registro = LocateRegistry.getRegistry(host,porta);
//
//        String[] listaCatalogo = registro.list();
//
//        for (String item : listaCatalogo){
//            System.out.println(item);
//        }
//
//        ISeguroViagemService seguroViagemService = (ISeguroViagemService) registro.lookup("rmi://10.100.32.89:1099/SeguroViagemService");
//
//        SeguroViagem seguro = seguroViagemService.buscarPorCidade("BEL");
//
//        Pacote pacote= new Pacote();
//        Item item= new Item();
//        item.setTipo(ItemServico.SEGURO);
//        item.setValor(seguro.getDiaria());
//        pacote.adicionarItens(item);
//
//        System.out.println(pacote.getTotal());
//
//
//
//    }
//}
