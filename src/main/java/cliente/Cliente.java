package cliente;

import model.PassagemAerea;
import utils.IPassagemAerea;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Cliente {
    public static void main(String[] args) {
        String host = "192.168.1.119";
        int porta = 2000;

        try {
            Registry registro = LocateRegistry.getRegistry(host, porta);

            // Busca o serviço específico pelo nome exato registrado no Servidor (Lookup)
            String nomeServico = "rmi://" + host + ":" + porta + "/passagemAerea";
            IPassagemAerea servico = (IPassagemAerea) registro.lookup(nomeServico);

            System.out.println("--- CONECTADO AO SERVIDOR ---");

            // Invoca os métodos remotos como se fossem locais

            System.out.println("\nVoos disponíveis a partir de Manaus:");
            List<PassagemAerea> passagens = servico.listar();
            for (PassagemAerea p : passagens) {
                System.out.println(p.getDestino() + " - R$ " + p.getPreco());
            }

        } catch (RemoteException | NotBoundException e) {
            System.out.println("Erro na comunicação com o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}