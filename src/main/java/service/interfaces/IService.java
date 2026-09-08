package service.interfaces;

import java.util.List;

public interface IService<T> {
    public List<T> getList();
    public String salvar(T objeto);
    public void remover(long id);
}
