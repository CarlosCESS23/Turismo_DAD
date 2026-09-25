package exceptions;

public class RegistroDuplicadoException extends Exception {
    public RegistroDuplicadoException(String mensagem) {
        super(mensagem);
    }
}