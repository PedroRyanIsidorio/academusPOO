package academus.repositorio;

import academus.modelo.Denuncia;
import java.util.ArrayList;

public class DenunciaRepositorio {

    private final ArrayList<Denuncia> denuncias = new ArrayList<>();

    public void adicionar(Denuncia denuncia) {
        denuncias.add(denuncia);
    }

    public ArrayList<Denuncia> listarTodas() {
        return denuncias;
    }

    public boolean isEmpty() {
        return denuncias.isEmpty();
    }
}
