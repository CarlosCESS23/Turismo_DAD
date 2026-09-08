package seguro;

import seguro.model.SeguroViagem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//Interface remota do serviço de Seguro Viagem.
public interface ISeguroViagemService extends Remote {

    List<SeguroViagem> listar() throws RemoteException;

    SeguroViagem buscarPorEstado(String estado) throws RemoteException;
}
