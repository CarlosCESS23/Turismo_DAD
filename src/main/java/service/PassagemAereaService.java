package service;

import model.PassagemAerea;

import java.util.ArrayList;
import java.util.List;

/* Carrega os dados das capitais de destino */
public class PassagemAereaService {

    List<PassagemAerea> passagens;

    public PassagemAereaService(){

        passagens = new ArrayList<>();

        // Região Norte
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Belém (BEL)", 1850));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Boa Vista (BVB)", 2900));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Macapá (MCP)", 2450));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Palmas (PMW)", 1650));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Porto Velho (PVH)", 2750));

    }

    /* Lista todas as capitais cadastradas */
    public List<PassagemAerea> listar(){
        return passagens;
    }

    /* Busca o preço das passagens */
    public PassagemAerea buscarPassagemAerea(String destino){
        for (PassagemAerea p : passagens) {
            if (p.getDestino().toLowerCase().contains(destino.toLowerCase())) {
                return p;
            }
        }
        return null;
    };
}
