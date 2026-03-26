package academus.repositorio;

import academus.excecoes.MatriculaNaoEncontradaException;
import academus.interfaces.IRepositorio;
import academus.modelo.Instrutor;
import java.util.ArrayList;

public class InstrutorRepositorio implements IRepositorio<Instrutor> {

    private final ArrayList<Instrutor> instrutores = new ArrayList<>();

    public void adicionar(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    public void remover(int matricula) {
        instrutores.removeIf(i -> i.getMatricula() == matricula);
    }

    public Instrutor buscar(int matricula) {
        for (Instrutor i : instrutores) {
            if (i.getMatricula() == matricula) return i;
        }
        throw new MatriculaNaoEncontradaException(matricula);
    }

    public ArrayList<Instrutor> listarTodos() {
        return instrutores;
    }
}