package academus;

import academus.modelo.Pessoa;
import academus.modelo.Aluno;
import academus.view.View;
import academus.repositorio.AlunoRepositorio;

import academus.modelo.Login;

public class Main{
    public static void main(String[] args){

        View view = new View();


        Aluno a = new Aluno("123");
        Login.getAlunoRepo().adicionar(a);


        System.out.println(a.getMatricula());
        view.init();
    }
}