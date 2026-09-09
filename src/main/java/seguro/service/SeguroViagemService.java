package seguro.service;

import seguro.model.SeguroViagem;

import java.util.ArrayList;
import java.util.List;

/*Serviço responsável pelos dados dos seguros viagem*/
public class SeguroViagemService {

    private List<SeguroViagem> seguros;

    public SeguroViagemService(){

        seguros = new ArrayList<>();

        seguros.add(new SeguroViagem("Acre", 8.00));
        seguros.add(new SeguroViagem("Alagoas", 10.00));
        seguros.add(new SeguroViagem("Amapá", 9.00));
        seguros.add(new SeguroViagem("Amazonas", 15.00));
        seguros.add(new SeguroViagem("Bahia", 11.00));
        seguros.add(new SeguroViagem("Ceará", 10.00));
        seguros.add(new SeguroViagem("Distrito Federal", 12.00));
        seguros.add(new SeguroViagem("Espírito Santo", 10.00));
        seguros.add(new SeguroViagem("Goiás", 9.00));
        seguros.add(new SeguroViagem("Maranhão", 9.50));
        seguros.add(new SeguroViagem("Mato Grosso", 9.50));
        seguros.add(new SeguroViagem("Mato Grosso do Sul", 9.00));
        seguros.add(new SeguroViagem("Minas Gerais", 9.50));
        seguros.add(new SeguroViagem("Pará", 9.00));
        seguros.add(new SeguroViagem("Paraíba", 10.00));
        seguros.add(new SeguroViagem("Paraná", 10.00));
        seguros.add(new SeguroViagem("Pernambuco", 10.50));
        seguros.add(new SeguroViagem("Piauí", 8.50));
        seguros.add(new SeguroViagem("Rio de Janeiro", 15.00));
        seguros.add(new SeguroViagem("Rio Grande do Norte", 10.00));
        seguros.add(new SeguroViagem("Rio Grande do Sul", 10.50));
        seguros.add(new SeguroViagem("Rondônia", 8.50));
        seguros.add(new SeguroViagem("Roraima", 9.50));
        seguros.add(new SeguroViagem("Santa Catarina", 12.00));
        seguros.add(new SeguroViagem("São Paulo", 20.00));
        seguros.add(new SeguroViagem("Sergipe", 9.50));
        seguros.add(new SeguroViagem("Tocantins", 8.50));
    }


    /*Méodo para retorna todos os seguros cadastrados*/
    public List<SeguroViagem> listar(){
        return seguros;
    }

    /*Método para buscar um seguro pelo estado*/
    public SeguroViagem buscarPorEstado(String estado){

        for(SeguroViagem seguro : seguros){

            if (seguro.getEstado().equalsIgnoreCase(estado)) {
                return seguro;
            }
        }
        return null;
    }

}
