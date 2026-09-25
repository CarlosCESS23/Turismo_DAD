package utils;

import exceptions.RegistroDuplicadoException;
import model.PassagemAerea;
import model.Reserva;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IPassagemAerea extends Remote {

    List<PassagemAerea> listar() throws RemoteException;

    PassagemAerea buscarPassagemAerea(String destino) throws RemoteException;

    void registrarReserva(Reserva reserva) throws RemoteException, RegistroDuplicadoException;
}
