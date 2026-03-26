package academus;

import academus.modelo.Pessoa;
import academus.modelo.Aluno;
import academus.modelo.Recepcionista;
import academus.view.View;
import academus.repositorio.AlunoRepositorio;

import academus.modelo.Login;

public class Main{
    public static void main(String[] args){

        View view = new View();

        Recepcionista adm = new Recepcionista("admin");
        adm.noUseSetMatricula(1234);

        Login.getRecepcionistaRepo().adicionar(adm);

        view.init(); //49500165
    }
}