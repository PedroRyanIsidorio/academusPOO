package academus.modelo;

import java.util.Random;

public class Aluno extends Pessoa{

    private String tipoDePlano;
    private String focoObjetivo; /// emagrecer, força, crescer
    private String restricao;

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

    public void setRestricao(String restricao){
        this.restricao = restricao;
    }

    @Override
    public int getMatricula(){
        return matricula;
    }


    //matricula 3d rand     001Aluno 002Instrutor 003Personal     2d rand//double rand = Math.random();
}