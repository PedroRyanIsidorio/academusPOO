package academus.excecoes;

public class PlanoNaoCadastradoException extends RuntimeException {
    public PlanoNaoCadastradoException() {
        super("Este aluno nao possui plano cadastrado.");
    }
}
