package academus.modelo;

import java.util.Random;

public class Pessoa{

    ///nome, altura, peso, idade, matricula, sexo
    Random random = new Random();
    private int matricula = random.nextInt(900) + 100;

    private String nome;
    private double altura;
    private double peso;
    private int idade;
    private boolean sexo;/// (true, masc), (false, fame)
    private String senha;

    public Pessoa(){}

    public Pessoa(String nome, double altura, double peso, int idade, boolean sexo, String senha){
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
        this.sexo = sexo;
        this.senha = senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public double getAltura(){
        return altura;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public double getPeso(){
        return peso;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getIdade(){
        return idade;
    }

    public void setSexo(boolean sexo){
        this.sexo = sexo;
    }

    public boolean getSexo(){
        return sexo;
    }

    public int getMatricula(){
        return matricula;
    }
}