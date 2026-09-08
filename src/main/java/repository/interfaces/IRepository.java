package repository.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IRepository<T> {
    public void save(T object) throws IOException;
    public List<T> getList() throws IOException;
    public void delete(long id) throws IOException;
}
