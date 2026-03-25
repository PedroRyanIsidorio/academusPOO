package academus.modelo;

import java.util.Random;

public class Instrutor extends Pessoa{

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

}