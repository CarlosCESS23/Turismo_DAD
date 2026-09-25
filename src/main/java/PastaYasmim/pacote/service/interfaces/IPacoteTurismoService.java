package PastaYasmim.pacote.service.interfaces;

import PastaYasmim.pacote.model.Pacote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public interface IPacoteTurismoService {
    public Pacote montarPacote(String origem, String destino) throws NotBoundException, RemoteException;
}
