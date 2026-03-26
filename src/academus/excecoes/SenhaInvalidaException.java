package academus.excecoes;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Senha incorreta!");
    }
}
