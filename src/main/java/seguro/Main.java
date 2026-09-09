package seguro;


import seguro.service.SeguroViagemService;
import seguro.service.SeguroViagemServiceImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//Servidor RMI do Seguro Viagem.
public class Main {
    public static void main(String[] args) {

        try {

            // Cria o Registry na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Cria o serviço RMI
            SeguroViagemServiceImpl service = new SeguroViagemServiceImpl();

            //Registra o serviço no Registry
            registry.rebind("SeguroViagemService", service);

            System.out.println("================================");
            System.out.println("     SEGURO VIAGEM - RMI");
            System.out.println("================================");
            System.out.println("Servidor iniciado!");
            System.out.println("Registry: porta 1099");
            System.out.println("Serviço: porta 2002");
            System.out.println("Nome: SeguroViagemService");
            System.out.println("Aguardando clientes...");

        } catch (Exception e) {

            System.out.println("Erro ao iniciar o servidor.");

            e.printStackTrace();
        }

    }
}
