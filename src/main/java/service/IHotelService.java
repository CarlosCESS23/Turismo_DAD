package service;

import model.Hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

public interface IHotelService extends Remote {

    public void adicionar(Hotel hotel) throws RemoteException;

    public List<Hotel> getLista() throws RemoteException;

    double calcularHospedagem(String cidade, LocalDate entrada, LocalDate saida) throws RemoteException;

    double consultarHotel(String cidade) throws RemoteException;
}