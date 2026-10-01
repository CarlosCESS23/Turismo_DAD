package servidor.helper;

import model.Hotel;
import service.IHotelService;
import servidor.rmi.HotelRMI;
import servidor.rmi.IConexao;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

public class HotelServiceHelper {

    IConexao<IHotelService> conexao = new HotelRMI();

    public Hotel consultarHotel(String destino) {
        try {
            IHotelService service = conexao.getConexao();
            List<Hotel> viagem = service.getLista();

            viagem.stream().forEach(System.out::println);

            Optional<Hotel> hotelSelecionado = viagem.stream()
                    .filter(hotel -> hotel.getCidade().equals(destino))
                    .findFirst();

            if (!(hotelSelecionado.isPresent())) {
                throw new RuntimeException("Hotel não encontrado");
            }


            return hotelSelecionado.get();

        } catch (RemoteException | NotBoundException e) {
            System.out.println("Erro ao fazer a consulta");
        }
        throw new RuntimeException();
    }
}
