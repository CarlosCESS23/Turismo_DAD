//package PastaYasmim.pacote.help;
//
//import model.SeguroViagem;
//import rmi.ISeguroViagemService;
//import PastaYasmim.pacote.ennum.ItemServico;
//import PastaYasmim.pacote.model.Item;
//import PastaYasmim.pacote.model.Pacote;
//
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//import java.rmi.registry.LocateRegistry;
//import java.rmi.registry.Registry;
//
//public class SeguroServiceHelper {
//
//    public Item consultarSeguroViagem(String destino) throws RemoteException, NotBoundException {
//        String host = "10.100.32.89";
//        int porta = 1099;
//
//        Registry registro = LocateRegistry.getRegistry(host,porta);
//
//        ISeguroViagemService seguroViagemService = (ISeguroViagemService) registro.lookup("rmi://10.100.32.89:1099/SeguroViagemService");
//
//        SeguroViagem seguro = seguroViagemService.buscarPorCidade("BEL");
//
//        Item item= new Item();
//        item.setTipo(ItemServico.SEGURO);
//        item.setValor(seguro.getDiaria());
//
//        return item;
//    }
//}
