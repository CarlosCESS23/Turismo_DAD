package servidor.util.interfaces;

import servidor.model.Item;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ISerializador {
    public Item serializar(Item item, File file) throws IOException;
    public List<Item> deserializar(String json, Class<Item> item) throws IOException;
}
