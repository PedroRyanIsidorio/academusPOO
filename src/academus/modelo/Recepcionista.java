package academus.modelo;

import java.util.Random;
import java.util.Scanner;

import academus.view.View;

public class Recepcionista extends Pessoa{

    Scanner sc = new Scanner(System.in);

    Random random = new Random();
    String mat = Integer.toString(super.getMatricula()) + "003" + Integer.toString(random.nextInt(90)+10);
    private int matricula = Integer.parseInt(mat);

    public Recepcionista(String nome, double altura, double peso, int idade, boolean sexo, String senha, int matricula){
        super(nome, altura, peso, idade, sexo, senha);
        this.matricula = matricula;
    }

    @Override
    public int getMatricula(){
        return matricula;
    }

    //String nome, double altura, double peso, int idade, boolean sexo, String senha, String restricao, String tipoDePlano, String focoObjetivo

    public void cadastrarAluno(){
        View.limparTela();
        View.topo();
        System.out.println("---Cadastrar-Aluno---");
        System.out.println("Nome do Aluno: ");
        String nome = sc.nextLine();
        System.out.println("Digite a altura: ");
        double altura = sc.nextDouble();
        System.out.println("Digite o peso: ");
        double peso = sc.nextDouble();
        System.out.println("Digite a idade: ");
        int idade = sc.nextInt();
        System.out.println("Digite o sexo (0) masculino, (1) feminino: ");
        boolean sexo = sc.nextBoolean();
        System.out.println("Digite a senha do aluno: ");
        String senha = sc.nextLine();
        System.out.println("Digite a restriçao: ");
        String restricao = sc.nextLine();
        System.out.println("Digite o plano: "); // tem que modificar
        String tipoDePlano = sc.nextLine();
        System.out.println("Digite o foco e objetivo: ");
        String focoObjetivo = sc.nextLine();
        Aluno aluno = new Aluno(nome, altura, peso, idade, sexo, senha, restricao, tipoDePlano, focoObjetivo);
        Login.getAlunoRepo().adicionar(aluno);
    }
}
