package service;

import repository.interfaces.IRepository;
import service.interfaces.IService;

import java.io.IOException;
import java.util.List;
import java.util.UnknownFormatConversionException;



public class ServiceImp<T> implements IService<T> {
    private final IRepository<T> iRepository;

    public ServiceImp(IRepository<T> repository){
        this.iRepository = repository;
    }

    @Override
    public List<T> getList() {
        try {
            return iRepository.getList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String salvar(T objeto) {
        try{
            iRepository.save(objeto);
        }catch (IOException e){
            throw new RuntimeException(e + "Erro ao serializar, por favor, tente novamente");
        }
        return "Sucesso, foi serializado";
    }

    @Override
    public void remover(long id) {
        try {
            iRepository.delete(id);
        } catch (IOException e) {
            throw new RuntimeException("Erro: Não foi possível encontrar a pasta ou está vazia , log do erro: " + e);
        }catch (UnknownFormatConversionException e){
            throw new UnknownFormatConversionException("Erro: Não foi possível encontrar o ID, log do erro: " + e);
        }
    }

}
