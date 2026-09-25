package servidor.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import servidor.model.Item;

import servidor.util.interfaces.ISerializador;

import java.io.IOException;
import java.io.File;
import java.util.List;

public class SerializadorImpl implements ISerializador {
    private final ObjectMapper serializador;

    public SerializadorImpl(){
        serializador = new ObjectMapper();
        this.serializador.enable(
                SerializationFeature.
                        INDENT_OUTPUT
        );
    }

    @Override
    public Item serializar(Item item, File file) throws IOException {
        System.out.println("Serializado com sucesso, veja se foi salvo!!!");
        // Seleciona o arquivo e escreve nele as informações
        serializador.writeValue(file,item);
        return item;
    }

    @Override
    public List<Item> deserializar(String json, Class<Item> item) throws JsonProcessingException {
        List<Item> objeto_convertido;

        // Pegando o Json e convertendo para o Objeto
        objeto_convertido = serializador.readValue(json,
                serializador
                        .getTypeFactory()
                        .constructCollectionType(List.class,item)
        );

        return objeto_convertido;

    }
}
