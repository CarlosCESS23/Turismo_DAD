package cliente;

import exceptions.RegistroDuplicadoException;
import model.Reserva;
import utils.IPassagemAerea;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        String host = "192.168.1.119";
        int porta = 2000;

        try {
            Registry registro = LocateRegistry.getRegistry(host, porta);
            String nomeServico = "rmi://" + host + ":" + porta + "/passagemAerea";
            IPassagemAerea servico = (IPassagemAerea) registro.lookup(nomeServico);

            // Cria uma reserva atrelada a um pacote
            Reserva reserva = new Reserva("PAC-994", "123.456.789-00", "Macapá (MCP)");

            System.out.println("--- INICIANDO TESTE DE INSERÇÃO E DUPLICIDADE ---\n");

            // Tentativa com o ID da Reserva
            System.out.println("[TENTATIVA 1] Enviando requisição para salvar reserva ID: " + reserva.getIdPacote());
            servico.registrarReserva(reserva);
            System.out.println("Reserva confirmada com sucesso!\n");

            // Simulação de retransmissão por instabilidade de rede
            System.out.println("...simulando instabilidade de rede e reenvio do pacote...\n");

            // Outra Tentativa: aciona a RegistroDuplicadoException no servidor
            System.out.println("[TENTATIVA 2] Reenviando a mesma requisição ID: " + reserva.getIdPacote());
            servico.registrarReserva(reserva);
            System.out.println("Reserva confirmada com sucesso! (Isso não deve ser impresso)");

        } catch (RegistroDuplicadoException e) {
            System.out.println("(EXCEÇÃO CAPTURADA): " + e.getMessage());

        } catch (RemoteException | NotBoundException e) {
            System.out.println("Erro crítico de conexão RMI: " + e.getMessage());
        }
    }
}