package academus.repositorio;

import academus.modelo.Instrutor;
import java.util.ArrayList;

public class InstrutorRepositorio {

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
        return null;
    }

    public ArrayList<Instrutor> listarTodos() {
        return instrutores;
    }
}