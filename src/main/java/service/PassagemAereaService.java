package service;

import exceptions.RegistroDuplicadoException;
import model.PassagemAerea;
import model.Reserva;

import java.util.ArrayList;
import java.util.List;

/* Carrega os dados das capitais de destino */
public class PassagemAereaService {

    List<PassagemAerea> passagens;

    private List<Reserva> reservasRegistradas;

    public PassagemAereaService() {

        passagens = new ArrayList<>();

        // Região Norte
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Belém (BEL)", 1850));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Boa Vista (BVB)", 2900));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Macapá (MCP)", 2450));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Palmas (PMW)", 1650));
        passagens.add(new PassagemAerea(PassagemAerea.origem, "Porto Velho (PVH)", 2750));

        reservasRegistradas = new ArrayList<>();
    }

    /* Lista todas as capitais cadastradas */
    public List<PassagemAerea> listar() {
        return passagens;
    }

    /* Busca o preço das passagens */
    public PassagemAerea buscarPassagemAerea(String destino) {
        for (PassagemAerea p : passagens) {
            if (p.getDestino().toLowerCase().contains(destino.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    public void registrarReserva(Reserva novaReserva) throws RegistroDuplicadoException {
        // Verifica duplicidade
        for (Reserva r : reservasRegistradas) {
            if (r.getIdPacote().equals(novaReserva.getIdPacote())) {
                throw new RegistroDuplicadoException("Falha na Inserção: O Pacote Turístico ID '"
                        + novaReserva.getIdPacote() + "' já está registrado neste serviço. Evitando duplicidade de cobrança/reserva.");
            }
        }

        reservasRegistradas.add(novaReserva);
        System.out.println("Log Servidor: Nova reserva salva com sucesso -> " + novaReserva.getIdPacote());
    }
}
