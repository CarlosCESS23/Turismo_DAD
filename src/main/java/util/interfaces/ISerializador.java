package util.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ISerializador<T> {
    void serializar(List<T> objeto, File salvarArquivo) throws IOException;

    List<T> deserializarLista(String json, Class<T> classe) throws JsonProcessingException;
}
