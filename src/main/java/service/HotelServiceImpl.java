package service;

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
        this.hoteis.add(new Hotel("Boa Vista", 250.00));
        this.hoteis.add(new Hotel("Belém", 100.00));
        this.hoteis.add(new Hotel("Macapá", 220.00));
        this.hoteis.add(new Hotel("Palmas", 150.00));
        this.hoteis.add(new Hotel("Porto Velho", 120.00));
    }

    public HotelServiceImpl() throws RemoteException{
        super();
        adicionarHoteis();
    }

    public void adicionar(Hotel hotel) throws RemoteException{
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
        throw new RemoteException("Essa cidade não está inclusa nesse pacote turístico.");
    }
}
