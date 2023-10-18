package src.Aplication;

import src.Entities.Aplicativo;
import src.UI.Tela;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tela tela = new Tela();
    }
//    public static void main(String[] args) {
//        Aplicativo app = new Aplicativo();
//        Scanner sc = new Scanner(System.in);
//        while(true) {
//            if(app.usuarioLogado == null) {
//                System.out.println("1) LOGIN");
//                System.out.println("2) CADASTRAR");
//                System.out.print("Digite a opção: ");
//                int opcao = sc.nextInt();
//                switch (opcao) {
//                    case 1 -> app.loginUsuario();
//                    case 2 -> app.cadastraUsuario();
//                }
//            } else if (app.usuarioLogado.restaurante == null) {
//                System.out.println("1) listar restaurantes");
//                System.out.println("2) fazer pedido");
//                System.out.println("3) logout");
//                System.out.print("Digite a opção: ");
//                int opcao = sc.nextInt();
//                switch (opcao) {
//                    case 1 -> app.listarRestaurantes();
//                    case 2 -> app.fazerPedido();
//                    case 3 -> app.logoutUsuario();
//                }
//            } else {
//                System.out.println("1) listar restaurantes");
//                System.out.println("2) fazer pedido");
//                System.out.println("3) Seu restaurante");
//                System.out.println("4) logout");
//                System.out.print("Digite a opção: ");
//                int opcao = sc.nextInt();
//                switch (opcao) {
//                    case 1 -> app.listarRestaurantes();
//                    case 2 -> app.fazerPedido();
//                    case 3 -> app.restaurante();
//                    case 4 -> app.logoutUsuario();
//                }
//            }
//        }
//    }
}
