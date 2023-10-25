package src.Entities;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Aplicativo {
    public ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    public Usuario usuarioLogado = null;
    public Restaurante restauranteLogado = null;

    public Usuario cadastraRestaurante(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        Restaurante restaurante = new Restaurante(usuario.nome, usuario.endereco);
        this.restauranteLogado = restaurante;
        this.restaurantes.add(restaurante);
        return usuario;
    }
//
//    public void cadastraUsuario() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Digite seu nome: ");
//        String nome = sc.nextLine();
//
//        System.out.println("Digite seu endereco X: ");
//        int enderecoX = sc.nextInt();
//
//        System.out.println("Digite seu endereco Y: ");
//        int enderecoY = sc.nextInt();
//
//        Endereco endereco = new Endereco(enderecoX, enderecoY);
//
//        System.out.println("Digite seu cpf: ");
//        String cpf = sc.nextLine();
//
//        System.out.println("Digite sua senha: ");
//        String senha = sc.nextLine();
//
//        System.out.println("É um restaurante(S/N): ");
//        String isRestaurante = sc.nextLine();
//
//        Usuario usuario = new Usuario(nome, endereco, cpf, senha);
//
//        if (Objects.equals(isRestaurante, "S")) {
//            usuario = cadastraRestaurante(usuario);
//        }
//
//        this.usuarios.add(usuario);
//    }

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

    public void logoutUsuario() {
        usuarioLogado = null;
    }

    public void listarRestaurantes() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for(Restaurante restaurante: restaurantes) {
            System.out.println(count +") " + restaurante.nome);
            count ++;
        }
    }

//    public void fazerPedido() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Escolha um restaurante: ");
//        int escolha = sc.nextInt();
//
//        Restaurante restauranteEscolhido = restaurantes.get(escolha);
//
//        Pedido novoPedido = new Pedido(restauranteEscolhido, this.usuarioLogado);
//
//        restauranteEscolhido.impormirCardapio();
//        System.out.println("Escolha um lanche: ");
//        int escolhaLanche = sc.nextInt();
//        Lanche lanche = restauranteEscolhido.listaLanches.get(escolhaLanche);
//
//        System.out.println("Quantidade de lanche: ");
//        int qntLanche = sc.nextInt();
//
//        novoPedido.fazerPedido(lanche, qntLanche);
//    }
//    public void restaurante() {
//        Scanner sc = new Scanner(System.in);
//        boolean continuar = true;
//        while(continuar) {
//            System.out.println("1) Listar lanches");
//            System.out.println("2) Adicionar lanche");
//            System.out.println("3) Remover lanche");
//            System.out.println("4) Voltar");
//            System.out.print("Digite a opção: ");
//            int opcao = sc.nextInt();
//            switch (opcao) {
//                case 1 -> this.restauranteLogado.impormirCardapio();
//                case 2 -> this.restauranteLogado.adicionarLanche();
//                case 3 -> this.restauranteLogado.removerLanche();
//                case 4 -> continuar = false;
//            }
//
//        }
//    }
}
