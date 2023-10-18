package Entities;

public class Pedido {
    public Restaurante restaurante;
    public Usuario usuario;

    public Pedido(Restaurante restaurante, Usuario usuario) {
        this.restaurante = restaurante;
        this.usuario = usuario;
    }

    public void fazerPedido() {}

    public void imprimirPedido() {}
}
