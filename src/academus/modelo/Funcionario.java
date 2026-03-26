package academus.modelo;

import academus.interfaces.IFuncionario;
import academus.view.View;
import java.util.Scanner;

public abstract class Funcionario extends Pessoa implements IFuncionario {

    protected Scanner sc = new Scanner(System.in);
    protected View view = new View();

    public Funcionario(String nome, double altura, double peso, int idade, boolean sexo, String senha) {
        super(nome, altura, peso, idade, sexo, senha);
    }

    public Funcionario(String senha) {
        super(senha);
    }

    @Override
    public void verMeuSalario() {
        View.limparTela();
        View.topo();
        System.out.println("---Meu Salario---");
        System.out.println("Salario: R$ 1.518,00");
        voltar();
    }

    @Override
    public void deixarAvisoParaRecepcionista() {
        View.limparTela();
        View.topo();
        System.out.println("---Deixar Aviso---");
        System.out.print("Digite o aviso: ");
        String aviso = sc.nextLine();
        System.out.println("Aviso registrado com sucesso!");
        voltar();
    }

    @Override
    public void verMatricula() {
        View.limparTela();
        View.topo();
        System.out.println("---Ver Matricula---");
        System.out.println("Sua matricula e " + getMatricula());
        voltar();
    }

    @Override
    public void alterarSenha() {
        View.limparTela();
        View.topo();
        System.out.println("---Alterar Senha---");
        System.out.print("Digite sua nova senha: ");
        setSenha(sc.nextLine());
        System.out.println("Senha alterada com sucesso!");
        voltar();
    }

    protected abstract void voltar();
}
