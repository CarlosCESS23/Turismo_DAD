package service;

import model.PassagemAerea;

import java.util.ArrayList;
import java.util.List;

public class PassagemAereaService {

    List<PassagemAerea> passagens;

    public PassagemAereaService(){
        passagens = new ArrayList<>();

        passagens.add(new PassagemAerea(PassagemAerea.origem, "Belém (BEL)", 1850));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Boa Vista (BVB)", 2900));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Macapá (MCP)", 2450));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Palmas (PMW)", 1650));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Porto Velho (PVH)", 2750));
    }

    
    public void calcularPreco(PassagemAerea passagem) {
        String categoria = passagem.getCategoria();
        if (categoria == null) {
            return;
        }


        switch (categoria.toLowerCase()) {
            case "premium":
                passagem.setPreco(passagem.getPreco() * 2.0); // Aumento de 100%
                break;
            case "normal":
                passagem.setPreco(passagem.getPreco() * 1.5); // Aumento de 50%
                break;
            case "economico":
                passagem.setPreco(passagem.getPreco() * 1.0); // Preço base mantido
                break;
            default:
                System.out.println("Categoria inválida. O preço base foi mantido.");
                break;
        }
    }

    /* Lista todas as capitais cadastradas */
    public List<PassagemAerea> listar(){
        return passagens;
    }

    /* Busca a passagem pelo destino */
    public PassagemAerea buscarPassagemAerea(String destino){
        for (PassagemAerea p : passagens) {
            if (p.getDestino().toLowerCase().contains(destino.toLowerCase())) {
                return p;
            }
        }
        return null;
    }
}