package academus.repositorio;

import academus.excecoes.MatriculaNaoEncontradaException;
import academus.interfaces.IAutenticavel;
import academus.interfaces.IRepositorio;
import java.util.ArrayList;

public abstract class AbstractRepositorio<T extends IAutenticavel> implements IRepositorio<T> {

    protected final ArrayList<T> lista = new ArrayList<>();

    @Override
    public void adicionar(T obj) {
        lista.add(obj);
    }

    @Override
    public void remover(int matricula) {
        lista.removeIf(obj -> obj.getMatricula() == matricula);
    }

    @Override
    public T buscar(int matricula) {
        for (T obj : lista) {
            if (obj.getMatricula() == matricula) return obj;
        }
        throw new MatriculaNaoEncontradaException(matricula);
    }

    @Override
    public ArrayList<T> listarTodos() {
        return lista;
    }
}
