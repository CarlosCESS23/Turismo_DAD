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
        this.hoteis.add(new Hotel(1,"BEL", 250.00, 10.00));
        this.hoteis.add(new Hotel(2,"BVB", 100.00,10.00));
        this.hoteis.add(new Hotel(3,"MCP", 220.00, 10.00));
        this.hoteis.add(new Hotel(4,"PMW", 150.00, 10.00));
        this.hoteis.add(new Hotel(5,"PVH", 120.00, 10.00));
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

    public double calcularHospedagem(String cidade, LocalDate entrada, LocalDate saida, double taxa) throws RemoteException{
        long dias = ChronoUnit.DAYS.between(entrada, saida);

        for(Hotel h: hoteis){
            if(h.getCidade().equalsIgnoreCase(cidade)){
                double total = h.getValorDiaria() * dias;
                total = total * h.getTaxa();
                return total;
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
