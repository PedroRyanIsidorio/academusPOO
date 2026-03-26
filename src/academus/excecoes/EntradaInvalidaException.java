package academus.excecoes;

public class EntradaInvalidaException extends RuntimeException {
    public EntradaInvalidaException(int opcao) {
        super("Opcao invalida digitada: " + opcao);
    }
}
