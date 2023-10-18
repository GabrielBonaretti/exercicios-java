package Entities;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aplicativo {
    public ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    public Usuario usuarioLogado = null;
    public void cadastraRestaurante() {
        Restaurante restaurante = new Restaurante();
    }

    public void cadastraUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite seu endereco (X, Y): ");
        String endereco = sc.nextLine();

        System.out.println("Digite seu cpf: ");
        String cpf = sc.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();

        Usuario usuario = new Usuario(nome, endereco, cpf, senha);
        this.usuarios.add(usuario);
    }

    public void loginUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = sc.nextLine();

        for (Usuario user: usuarios) {
            if (Objects.equals(user.nome, nome) && Objects.equals(user.senha, senha)) {
                usuarioLogado = user;
            }
        }

        if (usuarioLogado == null) {
            System.out.println("alguma coisa ta errada");
        }
    }

    public void  logoutUsuario() {
        usuarioLogado = null;
    }

}
