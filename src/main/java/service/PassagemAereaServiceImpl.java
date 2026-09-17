package service;

import model.PassagemAerea;
import utils.IPassagemAerea;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class PassagemAereaServiceImpl extends UnicastRemoteObject implements IPassagemAerea {

    private PassagemAereaService service;

    public PassagemAereaServiceImpl() throws RemoteException{

        super(2000);

        service = new PassagemAereaService();
    }

    @Override
    public List<PassagemAerea> listar() throws RemoteException {
        return service.listar();
    }

    @Override
    public PassagemAerea buscarPassagemAerea(String destino) throws RemoteException {
        return service.buscarPassagemAerea(destino);
    }
}
