package repository;

import model.Pacote;

import java.util.List;

public interface IRepository<I> {
    public String add();
    public String rm();
    public I get();
    public List<I> list();
}
