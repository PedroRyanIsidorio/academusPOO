package academus.view;

import academus.modelo.Recepcionista;
import academus.modelo.Login;
import academus.modelo.Pessoa;
import academus.modelo.Aluno;
import academus.modelo.Instrutor;

import java.util.Scanner;

public class View{

    Scanner sc = new Scanner(System.in);

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void topo(){
        System.out.println("////////////ACADEMUS////////////");
    }

    public static void base(){
        System.out.println("///////////////////////////////");
    }

    public void fechar(){
        limparTela();
        System.out.println("Sessao finalizada.");
        base();
    }

    public void init(){
        topo();
        System.out.println("(1) Fazer login");
        System.out.println("(2) Ver Planos");
        System.out.println("(3) Fazer o cadastramento");
        System.out.println("(4) Contatos");
        System.out.println("(5) Sair");
        System.out.print("Digite o numero: ");

        int numero = sc.nextInt();
        if (numero < 1 || numero > 5) {
            System.out.println("O numero digito digitado e invalido!");
            init();
        }

        switch (numero){
            case 1: login(); break;
            case 2: //verPlanos(); break;
            case 3: fazerCadastramento(); break;
            case 4: //contatos(); break;
            case 5: fechar();break;
        }
    }

    public void fazerCadastramento(){
        limparTela();
        topo();
        System.out.println("Para Fazer o cadastramento é necessario contatar um recepcionista");
        System.out.println("Caso tenha um digite (1) para login");
        System.out.println("Caso nao tenha digite (2) para deixar recado");
        System.out.println("(3) Sair");
        System.out.print("Digite o numero: ");
        int fzc = sc.nextInt();

        if(fzc < 1 || fzc > 3){
            System.out.println("Numero digitado invalido, tende novamente.");
            fazerCadastramento();
        }

        switch (fzc){
            case 1: recepcionistaLogin(); break;
            case 2: deixarRecado(); break;
            case 3: fechar(); break;
        }
    }

    public void recepcionistaLogin(){
        limparTela();
        topo();
        System.out.println("---LOGIN-RECEPCIONISTA---");
        System.out.print("Digite sua matricula");
        int matricula = sc.nextInt();
        sc.nextLine();
        System.out.println();
        System.out.print("Digite sua senha");
        String senha = sc.nextLine();

        Pessoa p = Login.recpAutenticar(matricula, senha);

        if (p == null) {
            System.out.println("\nMatricula ou senha invalidos! Tente novamente.");
            sc.nextLine();
            recepcionistaLogin();
        }else if (p instanceof Recepcionista r) {
            menuRecepcionista(r);
        }
    }

    public void login(){
        limparTela();
        topo();
        System.out.println("---LOGIN---");
        System.out.print("Digite sua matricula");
        int matricula = sc.nextInt();
        sc.nextLine();
        System.out.println();
        System.out.print("Digite sua senha");
        String senha = sc.nextLine();

        Pessoa p = Login.autenticar(matricula, senha);

        if (p == null) {
            System.out.println("\nMatricula ou senha invalidos! Tente novamente.");
            sc.nextLine();
            login();
        } else if (p instanceof Aluno a) {
            menuAluno(a);

        } else if (p instanceof Instrutor i) {
            menuInstrutor(i);

        } else if (p instanceof Recepcionista r) {
            menuRecepcionista(r);
        }
    }

    public void menuAluno(Aluno a){
        limparTela();
        topo();
        System.out.println("(1) Ver meu plano");
        System.out.println("(2) Ver meu treino");
        System.out.println("(3) Marcar treino como feito");
        System.out.println("(4) Fazer denuncia anonima");
        System.out.println("(5) Cancelar matricula");
        System.out.println("(6) Ver data de vercimento");
        System.out.println("(7) Fazer Pagamento");
        System.out.println("(8) Ver minha matricula");;
        System.out.println("(9) Alterar senha");

        //pode colocar mais
        System.out.println("(10) Sair");

        int numero = sc.nextInt();
        if (numero < 1 || numero > 10) {
            System.out.println("O numero digito digitado e invalido!");
            init();
        }
        switch (numero){
            case 1: a.verPlano(); break;
            case 2: a.verMeuTreino(); break;
            case 3: a.marcarTreinoComoFeito(); break;
            case 4: a.fazerDenunciaAnonima(); break;
            case 5: a.cancelarMatricula(); break;
            case 6: a.verDataDeVencimento(); break;
            case 7: a.fazerPagamento(); break;
            case 8: a.verMatricula(); break;
            case 9: a.alterarSenha(); break;
            case 10: fechar(); break;
        }
    }

    public void menuInstrutor(Instrutor i){
        limparTela();
        topo();
        System.out.println("(1) Ver meu salario");
        System.out.println("(2) Cadastrar aluno");
        System.out.println("(3) Alterar dados de aluno");
        System.out.println("(4) Fazer denuncia anonima");
        System.out.println("(5) Cancelar vinculo");
        System.out.println("(6) Deixar aviso para recepcionista");
        System.out.println("(7) Ver minha matricula");
        System.out.println("(8) Alterar senha");
        //pode colocar mais
        System.out.println("(9) Sair");

        int numero = sc.nextInt();
        if (numero < 1 || numero > 9) {
            System.out.println("O numero digito digitado e invalido!");
            init();
        }
        switch (numero){
            case 1: i.verMeuSalario(); break;
            case 2: i.cadastrarAlunoInst(); break;
            case 3: i.alterarDadosAluno(); break;
            case 4: i.fazerDenunciaAnonima(); break;
            case 5: i.cancelarVinculo(); break;
            case 6: i.deixarAvisoParaRecepcionista(); break;
            case 7: i.verMatricula(); break;
            case 8: i.alterarSenha(); break;
            case 7: fechar(); break;
        }
    }

    public void menuRecepcionista(Recepcionista r){
        limparTela();
        topo();
        System.out.println("(1) Ver meu salario");
        System.out.println("(2) Cadastrar aluno");
        System.out.println("(3) Alterar dados de aluno");
        System.out.println("(4) Fazer denuncia anonima");
        System.out.println("(5) Cancelar vinculo");
        System.out.println("(6) Deixar aviso para recepcionista");
        System.out.println("(7) Listar alunos");
        System.out.println("(8) Listar Instrutores");
        System.out.println("(9) Listar recepcionistas");
        System.out.println("(10) Listar planos");
        System.out.println("(11) Remover aluno");
        System.out.println("(12) Remover instrutor");
        System.out.println("(13) Remover recepcionista");
        System.out.println("(14) Adicionar plano");
        System.out.println("(15) Excluir plano");
        System.out.println("(16) Cadastrar instrutor");
        System.out.println("(17) Cadastrar recepcionista");
        //pode colocar mais
        System.out.println("(18) Sair");

        int numero = sc.nextInt();
        if (numero < 1 || numero > 18) {
            System.out.println("O numero digito digitado e invalido!");
            init();
        }
        switch (numero){
            case 1: r.verMeuSalario(); break;
            case 2: r.cadastrarAluno(); break;
            case 3: r.alterarDadosAluno(); break;
            case 4: r.fazerDenunciaAnonima(); break;
            case 5: r.cancelarVinculo(); break;
            case 6: r.deixarAvisoParaRecepcionista(); break;
            case 7: r.listarAlunos(); break;
            case 8: r.listarInstrutores(); break;
            case 9: r.listarRecepcionistas(); break;
            case 10: r.listarPlanos(); break;
            case 11: r.removerAluno(); break;
            case 12: r.removerInstrutor(); break;
            case 13: r.removerRecepcionista(); break;
            case 14: r.adicionarPlano(); break;
            case 15: r.excluirPlano(); break;
            case 16: r.cadastrarInstrutor(); break;
            case 17: r.cadastrarRecepcionista(); break;
            case 18: fechar(); break;
        }
    }

}