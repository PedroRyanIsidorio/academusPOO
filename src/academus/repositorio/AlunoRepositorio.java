package academus.repositorio;

import academus.excecoes.MatriculaNaoEncontradaException;
import academus.interfaces.IRepositorio;
import academus.modelo.Aluno;
import java.util.ArrayList;

public class AlunoRepositorio implements IRepositorio<Aluno> {

    private final ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionar(Aluno aluno) {
        alunos.add(aluno);
    }

    public void remover(int matricula) {
        alunos.removeIf(a -> a.getMatricula() == matricula);
    }

    public Aluno buscar(int matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula() == matricula) return a;
        }
        throw new MatriculaNaoEncontradaException(matricula);
    }

    public ArrayList<Aluno> listarTodos() {
        return alunos;
    }
}