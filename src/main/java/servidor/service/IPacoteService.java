package servidor.service;

import servidor.model.Item;
import servidor.model.Pacote;
import servidor.utils.ItemServico;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public interface IPacoteService extends Remote {
    public Pacote buscarPacote(String origem, String destino) throws RemoteException;
    public List<Pacote> listarPacote() throws RemoteException;
    public void addPacote(Pacote pacote) throws RemoteException;
    public void rmPacote(Pacote pacote) throws RemoteException;

    public Pacote montarPacote(String origem, String Destino,int id,int quantPessoa) throws RemoteException;

    public List<Item> buscarTipo(ItemServico tipo)throws RemoteException ;
    public List<Item> buscarPorOrigemDestino(String origem, String destino)throws RemoteException ;


}
