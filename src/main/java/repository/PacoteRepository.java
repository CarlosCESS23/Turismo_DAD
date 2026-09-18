package repository;

import model.Pacote;

import java.util.Collections;
import java.util.List;

public class PacoteRepository implements IRepository<Pacote>{

    @Override
    public String add() {
        return "";
    }

    @Override
    public String rm() {
        return "";
    }

    @Override
    public Pacote get() {
        return null;
    }

    @Override
    public List<Pacote> list() {
        return Collections.emptyList();
    }
}
