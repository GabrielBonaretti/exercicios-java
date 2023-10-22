package src.UI.Layout;

import src.Entities.Lanche;
import src.Entities.Restaurante;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LancheLabel extends JLabel {
    public LancheLabel(int y, Lanche lanche, Delivery delivery, Restaurante restaurante) {
        this.setBounds(125, y, 500, 50);
        this.setLayout(null);

        JLabel nome = new JLabel(lanche.nome);
        nome.setFont(new Font("Arial", Font.BOLD,15));
        nome.setBounds(30, 0, 270, 50);
        this.add(nome);

        JLabel preco = new JLabel("R$ "+lanche.preco);
        preco.setFont(new Font("Arial", Font.BOLD,15));
        preco.setBounds(340, 0, 100, 50);
        this.add(preco);

        JButton button = new JButton("+");
        button.setFont(new Font("Arial", Font.BOLD,20));
        button.setBounds(430, 0, 50, 50);
        button.setBackground(new Color(240,240,240));
        button.setBorder(null);
        button.setFocusable(false);
        button.addActionListener(e -> {
            if (delivery.pedido.restaurante != null && !Objects.equals(delivery.pedido.restaurante.nome, restaurante.nome)) {
                delivery.pedido.restaurante = restaurante;
                delivery.pedido.carrinho.clear();
                delivery.orderLayout.recreateRequests();
            } else {
                delivery.pedido.restaurante = restaurante;
            }
            delivery.pedido.fazerPedido(lanche);
            delivery.orderLayout.recreateRequests();
        });
        this.add(button);
    }
}
