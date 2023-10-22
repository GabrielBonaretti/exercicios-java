package src.UI.Layout;

import src.Entities.Lanche;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class OrderLayout extends JLabel {
    public Delivery delivery;
    public OrderLayout(Delivery delivery) {
        this.delivery = delivery;
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setOpaque(true);
        this.setLayout(null);

        JLabel label = new JLabel("Carrinho");
        label.setBounds(125,90,200,40);
        label.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label);

        JLabel linha = new JLabel();
        linha.setBounds(125, 160, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);
        this.add(linha);
    }

    public void recreateRequests() {
        this.removeAll();
        this.repaint();
        this.revalidate();

        JLabel label = new JLabel("Carrinho");
        label.setBounds(125,90,200,40);
        label.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label);

        JLabel linha = new JLabel();
        linha.setBounds(125, 160, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);
        this.add(linha);


        int count = 0;
        for (Lanche lanche: this.delivery.pedido.carrinho) {
            JLabel texto = new JLabel();
            texto.setBounds(125, 190 + count * 70, 500, 50);
            this.setLayout(null);

            JLabel nome = new JLabel(lanche.nome);
            nome.setFont(new Font("Arial", Font.BOLD,15));
            nome.setBounds(30, 0, 270, 50);
            texto.add(nome);

            JLabel preco = new JLabel("R$ "+lanche.preco);
            preco.setFont(new Font("Arial", Font.BOLD,15));
            preco.setBounds(340, 0, 100, 50);
            texto.add(preco);

            JButton button = new JButton("-");
            button.setFont(new Font("Arial", Font.BOLD,20));
            button.setBounds(430, 0, 50, 50);
            button.setBackground(new Color(240,240,240));
            button.setBorder(null);
            button.setFocusable(false);
            button.addActionListener(e -> {
                delivery.pedido.carrinho.remove(lanche);
                recreateRequests();
            });
            texto.add(button);

            this.add(texto);
            count++;
        }

        if (count == 0) {
            JLabel noItems = new JLabel("Não há items no carrinho!", SwingConstants.CENTER);
            noItems.setBounds(275, 365, 200, 50);
            noItems.setFont(new Font("Arial", Font.BOLD,15));
            this.add(noItems);
        }
    }

}
