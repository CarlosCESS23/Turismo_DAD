package servidor.repository;

import java.util.List;

public interface IRepository<I> {
    public String add();
    public String rm();
    public I get();
    public List<I> list();
}
