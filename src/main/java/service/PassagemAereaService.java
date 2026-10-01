package service;

import model.PassagemAerea;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PassagemAereaService {

    List<PassagemAerea> passagens;

    public PassagemAereaService(){
        passagens = new ArrayList<>();

        // Região Norte
        Categoria categoriaPremium = new Categoria("Premium");
        Categoria categoriaNormal = new Categoria("Normal");
        Categoria categoriaEconomico = new Categoria("Economico");

        passagens.add(new PassagemAerea(PassagemAerea.origem, "Belém (BEL)", 1850));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Boa Vista (BVB)", 2900));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Macapá (MCP)", 2450));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Palmas (PMW)", 1650));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Porto Velho (PVH)", 2750));

        // Mapa de categorias e fatores de aumento de preço
        Map<Categoria, Double> mapCategorias = new HashMap<>();
        mapCategorias.put(categoriaPremium, 2.0); // Premium - Aumento de 100%
        mapCategorias.put(categoriaNormal, 1.5); // Normal - Aumento de 50%
        mapCategorias.put(categoriaEconomico, 1.0); // Econômico - Não aumenta o preço

        // Aplicar os fatores de aumento de preço
        for (PassagemAerea passagem : passagens) {
            Double fatorAumento = mapCategorias.get(passagem.getCategoria());
            if (fatorAumento != null) {
                passagem.setPreco(passagem.getPreco() * fatorAumento);
            }
        }
    }

    public void calcularPreco(){
        

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