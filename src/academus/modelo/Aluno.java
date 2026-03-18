package academus.modelo;

public class Aluno extends Pessoa {

    private int matricula;
    private String tipoDePlano;
    private int focoObjetivo;
    private String restricao;


    public Aluno(String nome, double altura, double peso, int idade, int matricula, String sexo, String restricao, String tipoDePlano) {
        super(nome, altura, peso, idade, matricula, sexo);
        this.matricula = matricula;
        this.restricao = restricao;
        this.tipoDePlano = tipoDePlano;



    }


    // matricula 3d rand     001Aluno 002Instrutor 003Personal     5d rand
    //double rand = Math.random();
}
