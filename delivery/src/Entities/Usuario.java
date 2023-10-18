package src.Entities;

public class Usuario {
    public String nome;
    public Endereco endereco;
    public String cpf;
    public String senha;
    public Restaurante restaurante;

    public Usuario(String nome, Endereco endereco, String cpf, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
