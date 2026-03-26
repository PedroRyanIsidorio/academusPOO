package academus.interfaces;

import java.util.ArrayList;

public interface IRepositorio<T> {
    void adicionar(T obj);
    void remover(int matricula);
    T buscar(int matricula);
    ArrayList<T> listarTodos();
}
