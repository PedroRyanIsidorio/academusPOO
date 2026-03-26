package academus.modelo;

import academus.repositorio.AlunoRepositorio;
import academus.repositorio.InstrutorRepositorio;
import academus.repositorio.RecepcionistaRepositorio;

public class Login {
    private static AlunoRepositorio alunoRepo = new AlunoRepositorio();
    private static InstrutorRepositorio instrutorRepo = new InstrutorRepositorio();
    private static RecepcionistaRepositorio recepcionistaRepo = new RecepcionistaRepositorio();

    public static AlunoRepositorio getAlunoRepo() {
        return alunoRepo;
    }

    public static InstrutorRepositorio getInstrutorRepo() {
        return instrutorRepo;
    }

    public static RecepcionistaRepositorio getRecepcionistaRepo() {
        return recepcionistaRepo;
    }

    public static Pessoa autenticar(int matricula, String senha) {

        for (Aluno a : alunoRepo.listarTodos()) {
            if (a.getMatricula() == matricula && senha.equals(a.getSenha())) return a;
        }

        for (Instrutor i : instrutorRepo.listarTodos()) {
            if (i.getMatricula() == matricula && senha.equals(i.getSenha())) return i;
        }

        for (Recepcionista r : recepcionistaRepo.listarTodos()) {
            if (r.getMatricula() == matricula && senha.equals(r.getSenha())) return r;
        }
        return null;
    }

    public static Pessoa recpAutenticar(int matricula, String senha) {

        for (Recepcionista r : recepcionistaRepo.listarTodos()) {
            if (r.getMatricula() == matricula && senha.equals(r.getSenha())) return r;
        }
        return null;
    }
}