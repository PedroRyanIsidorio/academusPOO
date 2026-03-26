package academus.modelo;

public class Denuncia {

    private static int contador = 1;

    private int id;
    private String descricao;
    private String tipo; // "Aluno", "Instrutor", "Recepcionista"

    public Denuncia(String descricao, String tipo) {
        this.id = contador++;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "[#" + id + " | " + tipo + "] " + descricao;
    }
}
