package academus.modelo;

import java.util.Random;
import java.util.Scanner;
import academus.modelo.Login;

import academus.view.View;

public class Aluno extends Pessoa{

    private String tipoDePlano;
    private String focoObjetivo; /// emagrecer, força, crescer
    private String restricao;

    View view = new View();

    Scanner sc = new Scanner(System.in);

    Random random = new Random();
    String mat = Integer.toString(super.getMatricula()) + "001" + Integer.toString(random.nextInt(90)+10);
    private int matricula = Integer.parseInt(mat);

    public Aluno(String senha){
        super.setSenha(senha);
    }

    public Aluno(String nome, double altura, double peso, int idade, boolean sexo, String senha, String restricao, String tipoDePlano, String focoObjetivo) {
        super(nome, altura, peso, idade, sexo, senha);
        this.restricao = restricao;
        this.tipoDePlano = tipoDePlano;
        this.focoObjetivo = focoObjetivo;
    }

    public void setTipoDePlano(String tipoDePlano){
        this.tipoDePlano = tipoDePlano;
    }

    public String getTipoDePlano(){
        return tipoDePlano;
    }

    public void setFocoObjetivo(String focoObjetivo){
        this.focoObjetivo = focoObjetivo;
    }

    public String getFocoObjetivo(){
        return focoObjetivo;
    }

    private String statusPagamento = "pendente";
    private String treino = null;

    public void setTreino(String treino){
        this.treino = treino;
    }

    public String getTreino(){
        return treino;
    }

    public void setRestricao(String restricao){
        this.restricao = restricao;
    }

    public void verPlano(){
        System.out.println("---Meu Plano---");
        if (tipoDePlano.equalsIgnoreCase("anual")) {
            System.out.println("Plano: Anual - R$ 90,00/ano");
        } else if (tipoDePlano.equalsIgnoreCase("mensal")) {
            System.out.println("Plano: Mensal - R$ 116,00/mes");
        } else {
            System.out.println("Plano: " + tipoDePlano);
        }
        voltar();
    }

    public void verMeuTreino(){
        System.out.println("---Meu Treino---");
        if (treino == null) {
            System.out.println("Nenhum treino cadastrado ainda. Aguarde seu instrutor.");
        } else {
            System.out.println(treino);
        }
        voltar();
    }

    public void marcarTreinoComoFeito(){
        System.out.println("---Marcar Treino Como Feito---");
        if (treino == null) {
            System.out.println("Voce nao possui treino cadastrado.");
        } else {
            System.out.println("Treino marcado como feito! Bom trabalho!");
        }
        voltar();
    }

    public void fazerDenunciaAnonima(){
        System.out.println("---Denuncia Anonima---");
        Scanner sc = new Scanner(System.in);
        System.out.print("Descreva a denuncia: ");
        String denuncia = sc.nextLine();
        System.out.println("Denuncia registrada com sucesso!");
        voltar();
    }

    public void cancelarMatricula(){
        System.out.println("Matricula cancelada com sucesso!");
        Login.getAlunoRepo().remover(this.getMatricula());
    }

    public void verDataDeVencimento(){
        System.out.println("---Data de Vencimento---");
        if (tipoDePlano.equalsIgnoreCase("mensal")) {
            System.out.println("Seu plano vence todo dia 10 do mes.");
            System.out.println("Status do pagamento: " + statusPagamento);
        } else {
            System.out.println("Seu plano e anual, nao possui vencimento mensal.");
        }
        voltar();
    }

    public void fazerPagamento(){
        System.out.println("---Fazer Pagamento---");
        if (statusPagamento.equals("pago")) {
            System.out.println("Seu plano ja esta pago!");
        } else {
            statusPagamento = "pago";
            System.out.println("Pagamento realizado com sucesso! Status: pago");
        }
        voltar();
    }

    public void verMatricula(){
        System.out.println("---Meus Dados---");
        System.out.println("Nome: " + getNome());
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Plano: " + tipoDePlano + (tipoDePlano.equalsIgnoreCase("mensal") ? " - R$ 116,00/mes" : " - R$ 90,00/mes"));
        System.out.println("Status pagamento: " + statusPagamento);
        System.out.println("Treino: " + (treino == null ? "Nao cadastrado" : treino));
        System.out.println("Foco/Objetivo: " + focoObjetivo);
        System.out.println("Restricao: " + restricao);
        voltar();
    }

    public void alterarSenha(){
        System.out.println("---Alterar Senha---");
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a senha atual: ");
        String senhaAtual = sc.nextLine();
        if (!senhaAtual.equals(getSenha())) {
            System.out.println("Senha incorreta!");
            return;
        }
        System.out.print("Digite a nova senha: ");
        String novaSenha = sc.nextLine();
        setSenha(novaSenha);
        System.out.println("Senha alterada com sucesso!");
        voltar();
    }

    private void voltar(){
        System.out.println("Enter para voltar");
        sc.nextLine();
        view.menuAluno(this);
    }

    @Override
    public int getMatricula(){
        return matricula;
    }


    //matricula 3d rand     001Aluno 002Instrutor 003Personal     2d rand//double rand = Math.random();
}