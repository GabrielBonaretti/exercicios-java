package src.Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    public String nome;
    public Endereco localizacao;
    public ArrayList<Lanche> listaLanches = new ArrayList<Lanche>();

    public Restaurante(String nome, Endereco localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public void impormirCardapio() {
        int count = 0;
        for (Lanche lanche: listaLanches) {
            System.out.println(count+") "+lanche.nome);
            count ++;
        }
    }

    public void adicionarLanche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o preco: ");
        double preco = sc.nextDouble();

        listaLanches.add(new Lanche(nome, preco));
    }
    public void removerLanche() {
        Scanner sc = new Scanner(System.in);
        impormirCardapio();

        System.out.println("Escolha um lanche: ");
        int escolha = sc.nextInt();
        listaLanches.remove(escolha);

    }
}
