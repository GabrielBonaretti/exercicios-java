package src.Entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    public int id;

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

    public void adicionarLanche(Lanche lanche) {
        listaLanches.add(lanche);
    }

    public void removerLanche() {
        Scanner sc = new Scanner(System.in);
        impormirCardapio();

        System.out.println("Escolha um lanche: ");
        int escolha = sc.nextInt();
        listaLanches.remove(escolha);
    }

    public void setListaLanches(ArrayList<Lanche> listaLanches) {
        this.listaLanches = listaLanches;
    }

    public void setId(int id) {
        this.id = id;
    }

}
