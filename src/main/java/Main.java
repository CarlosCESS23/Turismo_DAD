import model.PassagemAerea;
import service.PassagemAereaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inicializa o Scanner e o Service
        Scanner teclado = new Scanner(System.in);
        PassagemAereaService service = new PassagemAereaService();

        System.out.println("=== BEM-VINDO AO SISTEMA DE PASSAGENS ===");
        System.out.println("Origem padrão: " + PassagemAerea.origem);

        // Pede a entrada do usuário
        System.out.print("\nDigite a cidade ou sigla de destino: ");
        String destinoDesejado = teclado.nextLine();

        // Chama o service para buscar o destino digitado
        PassagemAerea passagemEncontrada = service.buscarPassagemAerea(destinoDesejado);

        // Verifica o resultado e imprime na tela
        if (passagemEncontrada != null) {
            System.out.println("\n--- Passagem Encontrada ---");
            System.out.println(passagemEncontrada);
            System.out.println("---------------------------");
        } else {
            System.out.println("\nDesculpe, não encontramos voos para o destino: " + destinoDesejado);
        }

        teclado.close();
    }
}
