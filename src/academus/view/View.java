package academus.view;

import academus.excecoes.AutenticacaoFalhouException;
import academus.excecoes.EntradaInvalidaException;
import academus.excecoes.PlanoNaoCadastradoException;
import academus.excecoes.SenhaInvalidaException;
import academus.modelo.Recepcionista;
import academus.modelo.Login;
import academus.modelo.Pessoa;
import academus.modelo.Aluno;
import academus.modelo.Instrutor;

import java.util.InputMismatchException;
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

        try {
            int numero = sc.nextInt();
            if (numero < 1 || numero > 5) throw new EntradaInvalidaException(numero);
            switch (numero){
                case 1: login(); break;
                case 2: verPlanos(); break;
                case 3: fazerCadastramento(); break;
                case 4: contatos(); break;
                case 5: fechar(); break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas numeros!");
            sc.nextLine();
            init();
        } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            init();
        }
    }

    public void contatos(){
        limparTela();
        topo();
        System.out.println("Whatsapp: (88) 98115-4392");
        System.out.println("Email: academus@academus.gym");
        System.out.println("Instagram: @academusgym");
        System.out.println("Telefone 1: 0800 770 0051");
        System.out.println("Telefone 2: 0800 882 0041");
        System.out.println("(1) Voltar");
        System.out.println("(2) Sair");
        System.out.print("Digite o numero: ");

        try {
            int numero = sc.nextInt();
            if (numero < 1 || numero > 2) throw new EntradaInvalidaException(numero);
            switch (numero){
                case 1: init(); break;
                case 2: fechar(); break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas numeros!");
            sc.nextLine();
            contatos();
        } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            contatos();
        }
    }

    public void verPlanos(){
        limparTela();
        topo();
        System.out.println("---Planos Disponiveis---");
        System.out.println("(1) Anual  - R$ 90,00/anual");
        System.out.println("(2) Mensal - R$ 116,00/mes");
        System.out.println("\nPressione Enter para voltar...");
        sc.nextLine();
        sc.nextLine();
        init();
    }

    public void deixarRecado(){
        limparTela();
        topo();
        System.out.println("---Deixar Recado---");
        System.out.print("Digite seu nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Digite seu contato (telefone ou email): ");
        String contato = sc.nextLine();
        System.out.println("Recado registrado! Entraremos em contato em breve, " + nome + ".");
        init();
    }

    public void fazerCadastramento(){
        limparTela();
        topo();
        System.out.println("Para Fazer o cadastramento é necessario contatar um recepcionista");
        System.out.println("Caso tenha um digite (1) para login");
        System.out.println("Caso nao tenha digite (2) para deixar recado");
        System.out.println("(3) Sair");
        System.out.print("Digite o numero: ");

        try {
            int fzc = sc.nextInt();
            if (fzc < 1 || fzc > 3) throw new EntradaInvalidaException(fzc);
            switch (fzc){
                case 1: recepcionistaLogin(); break;
                case 2: deixarRecado(); break;
                case 3: fechar(); break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas numeros!");
            sc.nextLine();
            fazerCadastramento();
        } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            fazerCadastramento();
        }
    }

    public void recepcionistaLogin(){
        limparTela();
        topo();
        System.out.println("---LOGIN-RECEPCIONISTA---");
        System.out.print("Digite sua matricula: ");

        try {
            int matricula = sc.nextInt();
            sc.nextLine();
            System.out.println();
            System.out.print("Digite sua senha: ");
            String senha = sc.nextLine();
            Pessoa p = Login.recpAutenticar(matricula, senha);
            if (p == null) throw new AutenticacaoFalhouException();
            if (p instanceof Recepcionista r) menuRecepcionista(r);
        } catch (InputMismatchException e) {
            System.out.println("Erro: A matricula deve conter apenas numeros!");
            sc.nextLine();
            recepcionistaLogin();
        } catch (AutenticacaoFalhouException e) {
            System.out.println("\n" + e.getMessage());
            recepcionistaLogin();
        }
    }

    public void login(){
        limparTela();
        topo();
        System.out.println("---LOGIN---");
        System.out.print("Digite sua matricula: ");

        try {
            int matricula = sc.nextInt();
            sc.nextLine();
            System.out.println();
            System.out.print("Digite sua senha: ");
            String senha = sc.nextLine();
            Pessoa p = Login.autenticar(matricula, senha);
            if (p == null) throw new AutenticacaoFalhouException();
            if (p instanceof Aluno a) menuAluno(a);
            else if (p instanceof Instrutor i) menuInstrutor(i);
            else if (p instanceof Recepcionista r) menuRecepcionista(r);
        } catch (InputMismatchException e) {
            System.out.println("Erro: A matricula deve conter apenas numeros!");
            sc.nextLine();
            init();
        } catch (AutenticacaoFalhouException e) {
            System.out.println("\n" + e.getMessage());
            init();
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
        System.out.println("(10) Sair");
        System.out.println("Digite o numero: ");

        try {
            int numero = sc.nextInt();
            if (numero < 1 || numero > 10) throw new EntradaInvalidaException(numero);
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
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas numeros!");
            sc.nextLine();
            menuAluno(a);
        } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            menuAluno(a);
        } catch (PlanoNaoCadastradoException | SenhaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            menuAluno(a);
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
        System.out.println("Digite o numero: ");

        try {
            int numero = sc.nextInt();
            if (numero < 1 || numero > 9) throw new EntradaInvalidaException(numero);
            switch (numero){
                case 1: i.verMeuSalario(); break;
                case 2: i.cadastrarAlunoInst(); break;
                case 3: i.alterarDadosAluno(); break;
                case 4: i.fazerDenunciaAnonima(); break;
                case 5: i.cancelarVinculo(); break;
                case 6: i.deixarAvisoParaRecepcionista(); break;
                case 7: i.verMatricula(); break;
                case 8: i.alterarSenha(); break;
                case 9: fechar(); break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas numeros!");
            sc.nextLine();
            menuInstrutor(i);
        } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            menuInstrutor(i);
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
        System.out.println("Digite o numero: ");

        try {
            int numero = sc.nextInt();
            if (numero < 1 || numero > 18) throw new EntradaInvalidaException(numero);
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
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite apenas numeros!");
            sc.nextLine();
            menuRecepcionista(r);
        } catch (EntradaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
            menuRecepcionista(r);
        }
    }

}