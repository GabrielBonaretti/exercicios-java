package src.UI.Layout;

import src.Entities.Lanche;
import src.Entities.Restaurante;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LancheLabel extends JButton {
    public LancheLabel(Lanche lanche, Delivery delivery, Restaurante restaurante) {
        this.setPreferredSize(new Dimension(500, 50));
        this.setMinimumSize(new Dimension(500, 50));
        this.setMaximumSize(new Dimension(500, 50));
        this.setLayout(null);
        this.setBackground(new Color(240,240,240));
        this.addActionListener(e -> {
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

        JLabel nome = new JLabel(lanche.nome);
        nome.setFont(new Font("Arial", Font.BOLD,15));
        nome.setBounds(30, 0, 270, 50);
        this.add(nome);

        JLabel preco = new JLabel("R$ "+lanche.preco);
        preco.setFont(new Font("Arial", Font.BOLD,15));
        preco.setBounds(340, 0, 100, 50);
        this.add(preco);

        JLabel button = new JLabel("+");
        button.setFont(new Font("Arial", Font.BOLD,20));
        button.setBounds(430, 0, 50, 50);
        button.setBackground(new Color(240,240,240));
        button.setBorder(null);
        button.setFocusable(false);
        this.add(button);
    }
}
