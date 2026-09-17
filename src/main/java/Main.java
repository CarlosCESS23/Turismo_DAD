import model.PassagemAerea;
import service.PassagemAereaService;
import service.PassagemAereaServiceImpl;
import utils.IPassagemAerea;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String host = "192.168.1.119";
            System.setProperty("java.rmi.server.hostname", host);
            IPassagemAerea passagemAerea = new PassagemAereaServiceImpl();

            int porta = 2000;

            Registry registro = LocateRegistry.createRegistry(porta);

            registro.rebind(
                    "rmi://" + host + ":" + porta + "/passagemAerea",
                    passagemAerea
            );

            System.out.println("Servidor de Passagem Aérea rodando!");

        } catch (Exception e) {
            System.out.println("Erro ao iniciar");

            e.printStackTrace();
        }

    }
}
