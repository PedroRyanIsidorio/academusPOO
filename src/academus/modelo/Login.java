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
            if (a.getMatricula() == matricula && a.getSenha().equals(senha)) return a;
        }

        for (Instrutor i : instrutorRepo.listarTodos()) {
            if (i.getMatricula() == matricula && i.getSenha().equals(senha)) return i;
        }

        for (Recepcionista r : recepcionistaRepo.listarTodos()) {
            if (r.getMatricula() == matricula && r.getSenha().equals(senha)) return r;
        }



        if (matricula == 1 && senha.equals("admin")) return new Pessoa(); //lembrem de mudar isso
        return null;
    }

    public static Pessoa recpAutenticar(int matricula, String senha) {

        for (Recepcionista r : recepcionistaRepo.listarTodos()) {
            if (r.getMatricula() == matricula && r.getSenha().equals(senha)) return r;
        }

        if (matricula == 1 && senha.equals("admin")) return new Pessoa(); //lembrem de mudar isso
        return null;
    }
}