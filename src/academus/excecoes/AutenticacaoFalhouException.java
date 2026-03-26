package academus.excecoes;

public class AutenticacaoFalhouException extends RuntimeException {
    public AutenticacaoFalhouException() {
        super("Matricula ou senha invalidos.");
    }
}
