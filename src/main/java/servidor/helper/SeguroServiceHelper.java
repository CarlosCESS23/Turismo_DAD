package servidor.helper;

import seguro.ISeguroViagemService;
import seguro.model.SeguroViagem;
import servidor.rmi.IConexao;
import servidor.rmi.SeguroViagemRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SeguroServiceHelper {
    //Responsabilidade de fazer a consulta, nosso service
    private IConexao conexao = new SeguroViagemRMI();

    public SeguroViagem consultarSeguroViagem(String destino) {
        try {
            ISeguroViagemService service = (ISeguroViagemService) conexao.getConexao();

            SeguroViagem seguro = (SeguroViagem) service.buscarPorEstado(destino);

            return seguro;
        } catch (RemoteException | NotBoundException e) {
            System.out.println("Erro ao fazer a consulta, verifique se o servidor está ligado ou se a porta está correta e caminho");
        }
        throw new RuntimeException("Erro ao encontrar a classe");
    }
}
