package academus.modelo;

import academus.excecoes.MatriculaNaoEncontradaException;
import academus.interfaces.IFuncionario;
import academus.modelo.Denuncia;
import academus.view.View;

import java.util.Random;
import java.util.Scanner;

public class Instrutor extends Pessoa implements IFuncionario {

    Scanner sc = new Scanner(System.in);

    View view = new View();

    Random random = new Random();
    String mat = Integer.toString(super.getMatricula()) + "002" + Integer.toString(random.nextInt(90)+10);
    private int matricula = Integer.parseInt(mat);

    public Instrutor(String nome, double altura, double peso, int idade, boolean sexo, String senha, int matricula) {
        super(nome, altura, peso, idade, sexo, senha);
        this.matricula = matricula;
    }

    @Override
    public int getMatricula(){
        return matricula;
    }

    public void verMeuSalario(){
        View.limparTela();
        View.topo();
        System.out.println("---Meu Salario---");
        System.out.println("Salario: R$ 1.518,00");
        voltar();
    }

    public void cadastrarAlunoInst(){
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
        sc.nextLine();
        System.out.println("Digite a senha do aluno: ");
        String senha = sc.nextLine();
        System.out.println("Digite a restriçao: ");
        String restricao = sc.nextLine();
        System.out.println("Escolha o plano:");
        System.out.println("(1) Anual - R$ 90,00/mes");
        System.out.println("(2) Mensal - R$ 116,00/mes");
        int planoOpcao = sc.nextInt();
        sc.nextLine();
        String tipoDePlano = (planoOpcao == 1) ? "anual" : "mensal";
        System.out.println("Digite o foco e objetivo: ");
        String focoObjetivo = sc.nextLine();
        Aluno aluno = new Aluno(nome, altura, peso, idade, sexo, senha, restricao, tipoDePlano, focoObjetivo);
        Login.getAlunoRepo().adicionar(aluno);
        System.out.println("Aluno registrado!");
        voltar();
    }

    public void alterarDadosAluno(){
        View.limparTela();
        View.topo();
        System.out.println("---Alterar Dados de Aluno---");
        System.out.print("Digite a matricula do aluno: ");
        int matricula = sc.nextInt();
        sc.nextLine();
        try {
            Aluno aluno = Login.getAlunoRepo().buscar(matricula);
            System.out.print("Novo nome: "); aluno.setNome(sc.nextLine());
            System.out.print("Nova altura: "); aluno.setAltura(sc.nextDouble());
            System.out.print("Novo peso: "); aluno.setPeso(sc.nextDouble());
            System.out.print("Nova idade: "); aluno.setIdade(sc.nextInt()); sc.nextLine();
            System.out.println("Dados alterados com sucesso!");
        } catch (MatriculaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        voltar();
    }

    public void fazerDenunciaAnonima(){
        View.limparTela();
        View.topo();
        System.out.println("---Denuncia Anonima---");
        System.out.print("Descreva a denuncia: ");
        sc.nextLine();
        String descricao = sc.nextLine();
        Login.getDenunciaRepo().adicionar(new Denuncia(descricao, "Instrutor"));
        System.out.println("Denuncia registrada com sucesso!");
        voltar();
    }

    public void cancelarVinculo(){
        View.limparTela();
        View.topo();
        System.out.println("---Cancelar Vinculo---");
        System.out.println("Vinculo cancelado com sucesso!");
        Login.getInstrutorRepo().remover(this.getMatricula());
        voltar();
    }

    public void deixarAvisoParaRecepcionista(){
        View.limparTela();
        View.topo();
        System.out.println("---Deixar Aviso---");
        System.out.print("Digite o aviso: ");
        sc.nextLine();
        String aviso = sc.nextLine();
        System.out.println("Aviso registrado com sucesso!");
        voltar();
    }

    public void verMatricula(){
        View.limparTela();
        View.topo();
        System.out.println("---Ver-matricula---");
        System.out.println("Sua matricula é "+ matricula);
        voltar();
    }

    public void alterarSenha(){
        View.limparTela();
        View.topo();
        System.out.println("---Alterar-senha---");
        System.out.println("Digite sua nova senha: ");
        sc.nextLine();
        super.setSenha(sc.nextLine());
        System.out.println("Senha alterada com sucesso!");
        voltar();
    }

    private void voltar(){
        System.out.println("Enter para voltar");
        sc.nextLine();
        view.menuInstrutor(this);
    }
}