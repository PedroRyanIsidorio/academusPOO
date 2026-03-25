package academus.repositorio;

import academus.modelo.Aluno;
import java.util.ArrayList;

public class AlunoRepositorio {

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
        return null;
    }

    public ArrayList<Aluno> listarTodos() {
        return alunos;
    }
}