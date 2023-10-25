package src.Entities;

public class Usuario {
    public String nome;
    public Endereco endereco;
    public String cpf;
    public String senha;

    public Usuario(String nome, Endereco endereco, String cpf, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.senha = senha;
    }

}
