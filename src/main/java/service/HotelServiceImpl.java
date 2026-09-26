package service;

import exception.RegistroDuplicadoException;
import model.Hotel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class HotelServiceImpl extends UnicastRemoteObject implements IHotelService {

    List<Hotel> hoteis = new ArrayList<>();

    public void adicionarHoteis(){
        this.hoteis.add(new Hotel(1,"Boa Vista", 250.00));
        this.hoteis.add(new Hotel(2,"Belém", 100.00));
        this.hoteis.add(new Hotel(3,"Macapá", 220.00));
        this.hoteis.add(new Hotel(4,"Palmas", 150.00));
        this.hoteis.add(new Hotel(5,"Porto Velho", 120.00));
    }

    public HotelServiceImpl() throws RemoteException{
        super();
        adicionarHoteis();
    }

    public void adicionar(Hotel hotel) throws RemoteException, RegistroDuplicadoException{
        for(Hotel h : hoteis){
            if(h.getIdPacoteTuristico() == hotel.getIdPacoteTuristico()){

                throw new RegistroDuplicadoException("Esse ID ja foi registrado.");
            }
        }
        this.hoteis.add(hotel);
    }

    public List<Hotel> getLista() throws RemoteException{
        return this.hoteis;
    }

    public double calcularHospedagem(String cidade, LocalDate entrada, LocalDate saida) throws RemoteException{
        long dias = ChronoUnit.DAYS.between(entrada, saida);

        for(Hotel h: hoteis){
            if(h.getCidade().equalsIgnoreCase(cidade)){
                return h.getValorDiaria() * dias;
            }
        }
        throw new RemoteException();
    }
    public double consultarHotel(String cidade) throws RemoteException{

        for(Hotel h: hoteis){
            if(h.getCidade().equalsIgnoreCase(cidade)){
                return h.getValorDiaria();
            }
        }
        throw new RemoteException("Essa cidade não foi encontrada!");
    }

}
