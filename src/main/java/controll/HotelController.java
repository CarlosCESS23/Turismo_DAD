package controll;

import model.Hotel;
import repository.HotelRepositoryImpl;
import repository.interfaces.IRepository;
import service.ServiceImp;
import service.interfaces.IService;
import util.SerializadorJsonImpl;
import util.interfaces.ISerializador;

import java.util.ArrayList;
import java.util.List;


public class HotelController {

    private static final ISerializador<Hotel> serializador = new SerializadorJsonImpl<>();
    private static final IRepository<Hotel> repository = new HotelRepositoryImpl(serializador);
    private static final IService<Hotel> service = new ServiceImp<>(repository);



    public static void main(String[] args) {
        Hotel hotel1 = new Hotel(
                "Manaus Centro",
                "Amazonas",
                "250.00",
                1
        );

        Hotel hotel2 = new Hotel(
                "Ponta Negra",
                "Amazonas",
                "320.50",
                2
        );

        Hotel hotel3 = new Hotel(
                "Meireles",
                "Ceará",
                "280.90",
                3
        );

        Hotel hotel4 = new Hotel(
                "Boa Viagem",
                "Pernambuco",
                "310.00",
                4
        );

        Hotel hotel5 = new Hotel(
                "Copacabana",
                "Rio de Janeiro",
                "450.75",
                5
        );

        Hotel hotel6 = new Hotel(
                "Paulista",
                "São Paulo",
                "390.40",
                6
        );
        List<Hotel> hoteis = new ArrayList<>();
        hoteis.add(hotel1);
        hoteis.add(hotel2);
        hoteis.add(hotel3);
        hoteis.add(hotel4);
        hoteis.add(hotel5);
        hoteis.add(hotel6);
        hoteis.forEach(HotelController::adicionarHotel);

        removerHotel(2);
    }
    static void adicionarHotel(Hotel hotel){
        service.salvar(hotel);
    }

    static void listarHotel(){
        List<Hotel> lista_hotel =  service.getList();
        System.out.print(lista_hotel);
    }

    static void removerHotel(long id){
        service.remover(id);
    }
}
