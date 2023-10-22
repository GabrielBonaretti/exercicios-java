package src.Entities;

import java.util.ArrayList;
import java.util.Objects;

public class Pedido {
    public Restaurante restaurante;
    public Usuario usuario;
    public ArrayList<Lanche> carrinho = new ArrayList<Lanche>();
//    public Pedido(Restaurante restaurante, Usuario usuario) {
//        this.restaurante = restaurante;
//        this.usuario = usuario;
//    }

    public void fazerPedido(Lanche lanche) {
        ArrayList<Object> lanchePedido = new ArrayList<Object>();
        this.carrinho.add(lanche);
    }


//    public void imprimirPedido() {
//        System.out.printf("%-6s | %-17s | %-12s | %-13s \n", "ITEM", "PREÇO UNITÁRIO", "QUANTIDADE", "PREÇO TOTAL");
//        System.out.printf("----------------------------------------------------------------------\n");
//        double somaTotal = 0;
//        for (ArrayList<Object> item:carrinho) {
//            Lanche lanche = (Lanche) item.get(0);
//            int quantidade = (int) item.get(1);
//            System.out.printf("%-6s | %-17f | %-12d | %-13f \n", lanche.nome, lanche.preco, quantidade, lanche.preco*quantidade);
//            somaTotal += lanche.preco*quantidade;
//        }
//        System.out.printf("----------------------------------------------------------------------\n");
//        System.out.println("Preço total: " + somaTotal);
//    }
}
