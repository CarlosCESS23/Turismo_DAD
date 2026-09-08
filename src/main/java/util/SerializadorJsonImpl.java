package util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import util.interfaces.ISerializador;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializadorJsonImpl<T> implements ISerializador<T> {
    private final ObjectMapper conversor;

    public SerializadorJsonImpl() {
        this.conversor = new ObjectMapper();
        this.conversor.enable(
                SerializationFeature.
                        INDENT_OUTPUT
        );
    }

    public void serializar(List<T> objeto, File salvarArquivo) throws IOException {

        String mensagem = "";

        mensagem = String.format("Sucesso!!!, o arquivo foi serializado");
        // Converte toda a lista
        conversor.writeValue(salvarArquivo,objeto);

        System.out.println(mensagem);
        return;
    }

    // Transforma o Json em uma lista de objeto (Mesmo que tenha somente 1 objeto, ele fará 1 object)
    public List<T> deserializarLista(String json, Class<T> classe) throws JsonProcessingException {
        String mensagem = "";
        List<T> objetoConvertido;
        // Faz uma leitura e converte
        objetoConvertido = conversor.readValue(json,
                conversor.getTypeFactory()
                        .constructCollectionLikeType(List.class, classe));
        return objetoConvertido;
    }

}
