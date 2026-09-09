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
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Rio Branco (RBR)", 3100));

        // Região Nordeste
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Aracaju (AJU)", 1750));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Fortaleza (FOR)", 2300));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "João Pessoa (JPA)", 2150));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Maceió (MCZ)", 1950));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Natal (NAT)", 2250));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Recife (REC)", 2050));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Salvador (SSA)", 1600));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "São Luís (SLZ)", 1900));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Teresina (THE)", 1800));

        // Região Centro-Oeste
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Brasília (BSB)", 1200));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Campo Grande (CGR)", 1450));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Cuiabá (CGB)", 1550));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Goiânia (GYN)", 1100));

        // Região Sudeste
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Belo Horizonte (BHZ)", 980));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Rio de Janeiro (RIO)", 1150));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "São Paulo (SAO)", 850));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Vitória (VIX)", 1300));

        // Região Sul
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Curitiba (CWB)", 1250));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Florianópolis (FLN)", 1400));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Porto Alegre (POA)", 1700));

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
