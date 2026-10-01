package servidor.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface IConexao<T> {
    public T getConexao() throws RemoteException, NotBoundException;
}
