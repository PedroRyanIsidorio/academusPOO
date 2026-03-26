package academus.repositorio;

import academus.excecoes.MatriculaNaoEncontradaException;
import academus.interfaces.IRepositorio;
import academus.modelo.Recepcionista;
import java.util.ArrayList;

public class RecepcionistaRepositorio implements IRepositorio<Recepcionista> {

    private final ArrayList<Recepcionista> recepcionistas = new ArrayList<>();

    public void adicionar(Recepcionista recepcionista) {
        recepcionistas.add(recepcionista);
    }

    public void remover(int matricula) {
        recepcionistas.removeIf(i -> i.getMatricula() == matricula);
    }

    public Recepcionista buscar(int matricula) {
        for (Recepcionista r : recepcionistas) {
            if (r.getMatricula() == matricula) return r;
        }
        throw new MatriculaNaoEncontradaException(matricula);
    }

    public ArrayList<Recepcionista> listarTodos() {
        return recepcionistas;
    }
}