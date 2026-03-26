package academus.modelo;

import java.util.Random;

import academus.excecoes.MatriculaNaoEncontradaException;
import academus.modelo.Aluno;
import academus.modelo.Denuncia;
import academus.modelo.Instrutor;
import academus.view.View;

public class Recepcionista extends Funcionario {

    Random random = new Random();
    String mat = Integer.toString(super.getMatricula()) + "003" + Integer.toString(random.nextInt(90)+10);
    private int matricula = Integer.parseInt(mat);

    public Recepcionista(String senha){
        super(senha);
    }

    public Recepcionista(String nome, double altura, double peso, int idade, boolean sexo, String senha){
        super(nome, altura, peso, idade, sexo, senha);
    }

    @Override
    public int getMatricula(){
        return matricula;
    }

    public void noUseSetMatricula(int matricula){
        this.matricula = matricula;
    }

    @Override
    public void fazerDenunciaAnonima(){
        View.limparTela();
        View.topo();
        System.out.println("---Denuncia Anonima---");
        System.out.print("Descreva a denuncia: ");
        String descricao = sc.nextLine();
        Login.getDenunciaRepo().adicionar(new Denuncia(descricao, "Recepcionista"));
        System.out.println("Denuncia registrada com sucesso!");
        voltar();
    }

    @Override
    public void cancelarVinculo(){
        View.limparTela();
        View.topo();
        System.out.println("---Cancelar Vinculo---");
        System.out.println("Vinculo cancelado com sucesso!");
        Login.getRecepcionistaRepo().remover(this.getMatricula());
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

    public void listarAlunos(){
        View.limparTela();
        View.topo();
        System.out.println("---Lista de Alunos---");
        for (Aluno a : Login.getAlunoRepo().listarTodos()) {
            System.out.println("Matricula: " + a.getMatricula() + " | Nome: " + a.getNome() + " | Plano: " + a.getTipoDePlano());
        }
        voltar();
    }

    public void listarInstrutores(){
        View.limparTela();
        View.topo();
        System.out.println("---Lista de Instrutores---");
        for (Instrutor i : Login.getInstrutorRepo().listarTodos()) {
            System.out.println("Matricula: " + i.getMatricula() + " | Nome: " + i.getNome());
        }
        voltar();
    }

    public void listarRecepcionistas(){
        View.limparTela();
        View.topo();
        System.out.println("---Lista de Recepcionistas---");
        for (Recepcionista r : Login.getRecepcionistaRepo().listarTodos()) {
            System.out.println("Matricula: " + r.getMatricula() + " | Nome: " + r.getNome());
        }
        voltar();
    }

    public void listarPlanos(){
        View.limparTela();
        View.topo();
        System.out.println("---Planos Disponiveis---");
        System.out.println("Anual  - R$ 90,00/ano");
        System.out.println("Mensal - R$ 116,00/mes");
        voltar();
    }

    public void removerAluno(){
        View.limparTela();
        View.topo();
        System.out.println("---Remover Aluno---");
        System.out.print("Digite a matricula do aluno: ");
        int matricula = sc.nextInt();
        sc.nextLine();
        try {
            Login.getAlunoRepo().buscar(matricula);
            Login.getAlunoRepo().remover(matricula);
            System.out.println("Aluno removido com sucesso!");
        } catch (MatriculaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        voltar();
    }

    public void removerInstrutor(){
        View.limparTela();
        View.topo();
        System.out.println("---Remover Instrutor---");
        System.out.print("Digite a matricula do instrutor: ");
        int matricula = sc.nextInt();
        sc.nextLine();
        try {
            Login.getInstrutorRepo().buscar(matricula);
            Login.getInstrutorRepo().remover(matricula);
            System.out.println("Instrutor removido com sucesso!");
        } catch (MatriculaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        voltar();
    }

    public void removerRecepcionista(){
        View.limparTela();
        View.topo();
        System.out.println("---Remover Recepcionista---");
        System.out.print("Digite a matricula da recepcionista: ");
        int matricula = sc.nextInt();
        sc.nextLine();
        try {
            Login.getRecepcionistaRepo().buscar(matricula);
            Login.getRecepcionistaRepo().remover(matricula);
            System.out.println("Recepcionista removida com sucesso!");
        } catch (MatriculaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        voltar();
    }

    public void adicionarPlano(){
        View.limparTela();
        View.topo();
        System.out.println("Os planos disponiveis sao Anual e Mensal.");
        System.out.println("Nao e possivel adicionar novos planos no momento.");
        voltar();
    }

    public void excluirPlano(){
        View.limparTela();
        View.topo();
        System.out.println("Nao e possivel excluir planos no momento.");
        voltar();
    }

    public void cadastrarInstrutor(){
        View.limparTela();
        View.topo();
        System.out.println("---Cadastrar Instrutor---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Altura: "); double altura = sc.nextDouble();
        System.out.print("Peso: "); double peso = sc.nextDouble();
        System.out.print("Idade: "); int idade = sc.nextInt(); sc.nextLine();
        System.out.println("Digite o sexo (0) masculino, (1) feminino: ");
        int z = sc.nextInt();
        sc.nextLine();
        boolean sexo;
        if (z==1){
            sexo = true;
        }else if (z==0){
            sexo = false;
        }else{
            System.out.println("Entrada invalida!");
            voltar();
            return;
        }
        System.out.print("Senha: "); String senha = sc.nextLine();
        System.out.print("Matricula: "); int matricula = sc.nextInt(); sc.nextLine();
        Instrutor instrutor = new Instrutor(nome, altura, peso, idade, sexo, senha, matricula);
        Login.getInstrutorRepo().adicionar(instrutor);
        System.out.println("Instrutor cadastrado! Matricula: " + instrutor.getMatricula());
        voltar();
    }

    public void cadastrarRecepcionista(){
        View.limparTela();
        View.topo();
        System.out.println("---Cadastrar Recepcionista---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Altura: "); double altura = sc.nextDouble();
        System.out.print("Peso: "); double peso = sc.nextDouble();
        System.out.print("Idade: "); int idade = sc.nextInt(); sc.nextLine();
        System.out.println("Digite o sexo (0) masculino, (1) feminino: ");
        int z = sc.nextInt();
        sc.nextLine();
        boolean sexo;
        if (z==1){
            sexo = true;
        }else if (z==0){
            sexo = false;
        }else{
            System.out.println("Entrada invalida!");
            voltar();
            return;
        }
        System.out.print("Senha: "); String senha = sc.nextLine();
        System.out.print("Matricula: "); int matricula = sc.nextInt(); sc.nextLine();
        Recepcionista recepcionista = new Recepcionista(nome, altura, peso, idade, sexo, senha);
        recepcionista.noUseSetMatricula(matricula);
        Login.getRecepcionistaRepo().adicionar(recepcionista);
        System.out.println("Recepcionista cadastrada! Matricula: " + recepcionista.getMatricula());
        voltar();
    }

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
        int z = sc.nextInt();
        sc.nextLine();
        boolean sexo;
        if (z==1){
            sexo = true;
        }else if (z==0){
            sexo = false;
        }else{
            System.out.println("Entrada invalida!");
            voltar();
            return;
        }
        System.out.print("Digite a senha do aluno: ");
        String senha = sc.nextLine();
        System.out.print("Digite a restriçao: ");
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

    public void listarDenuncias(){
        View.limparTela();
        View.topo();
        System.out.println("---Denuncias Anonimas---");
        if (Login.getDenunciaRepo().isEmpty()) {
            System.out.println("Nenhuma denuncia registrada.");
        } else {
            for (Denuncia d : Login.getDenunciaRepo().listarTodas()) {
                System.out.println(d);
            }
        }
        voltar();
    }

    @Override
    protected void voltar(){
        System.out.println("Enter para voltar");
        sc.nextLine();
        view.menuRecepcionista(this);
    }
}
