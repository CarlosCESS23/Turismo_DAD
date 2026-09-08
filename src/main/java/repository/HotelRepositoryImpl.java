package repository;
import org.jetbrains.annotations.NotNull;
import repository.interfaces.IRepository;
import util.interfaces.ISerializador;
import model.Hotel;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UnknownFormatConversionException;

import config.Configuracao;



@SuppressWarnings({"unchecked", "rawtypes"})
public class HotelRepositoryImpl implements IRepository<Hotel> {
    private final ISerializador<Hotel> serializador;
    private final Configuracao configuracao = new Configuracao();
    private final File file;
    List<Hotel> hotels;

    public HotelRepositoryImpl(ISerializador serializador){
        this.serializador = serializador;
        this.file = new File(configuracao.PASTA_PADRAO() + "Hotel.json");
        this.hotels = new ArrayList<>();
    }

    @Override
    public void save(Hotel object) throws IOException {

        String json;

        //Verificar se o file não existe
        if (!(this.file.exists() && this.file.length() > 0)){
            hotels.add(object);
            serializador.serializar(hotels,this.file);
            return;
        }
        json = new String(
                Files.readAllBytes(file.toPath()),
                StandardCharsets.UTF_8
        );

        this.hotels = serializador.deserializarLista(
                json,
                model.Hotel.class
        );
        this.hotels.add(object);
        serializador.serializar(hotels,this.file);

    }

    private @NotNull String json() throws IOException {
        String json;
        if (!(this.file.exists() && this.file.length() > 0)){
            throw new IOException("O Arquivo não existe ou está vazio, verifique");

        }
        json = new String(
                Files.readAllBytes(file.toPath()),
                StandardCharsets.UTF_8
        );
        return json;
    }

    public List<Hotel> getList() throws IOException {

        this.hotels = serializador.deserializarLista(json(),model.Hotel.class);
        return this.hotels;
    }

    @Override
    public void delete(long id) throws IOException, UnknownFormatConversionException {
        // Simplesmente adiciona tudo
        this.hotels = serializador.deserializarLista(json(),model.Hotel.class);

        // Utilizando a biblioteca STREAM para vasculhar a estrutura de dados
        Optional<Hotel> hotelSelecionado = hotels.stream()
                .filter(hotel -> hotel.getID() == id)
                .findFirst();
        // Optional: Pode ser que venha null ou não

        if(!hotelSelecionado.isPresent()){
            throw new IOException(String.format("Não foi encontrado o ID selecionado: %d",id ));
        }

        this.hotels.remove(hotelSelecionado.get());

        serializador.serializar(hotels,file);
        hotels.forEach(System.out::println);

    }

}
