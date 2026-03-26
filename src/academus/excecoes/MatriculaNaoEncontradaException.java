package academus.excecoes;

public class MatriculaNaoEncontradaException extends RuntimeException {
    public MatriculaNaoEncontradaException(int matricula) {
        super("Matricula nao encontrada: " + matricula);
    }
}
