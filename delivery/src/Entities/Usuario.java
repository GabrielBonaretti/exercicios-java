package Entities;

public class Usuario {
    public String nome;
    public String endereco;
    public String cpf;
    public String senha;
    public boolean eRestaurante;

    public Usuario(String nome, String endereco, String cpf, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.senha = senha;
    }

}
