package src.UI.Layout;

import src.Entities.Lanche;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class OrderLayout extends JPanel {
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

        JLabel noItems = new JLabel("Não há items no carrinho!", SwingConstants.CENTER);
        noItems.setBounds(275, 365, 200, 50);
        noItems.setFont(new Font("Arial", Font.BOLD,15));
        this.add(noItems);
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

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setVisible(true);

        int count = 0;
        for (ArrayList<Object> pedidoLanche: this.delivery.pedido.carrinho) {
            Lanche lanche = (Lanche) pedidoLanche.get(0);
            int qntLanche = (int) pedidoLanche.get(1);

            JButton lancheButton = new JButton();
            lancheButton.setPreferredSize(new Dimension(500, 50));
            lancheButton.setMinimumSize(new Dimension(500, 50));
            lancheButton.setMaximumSize(new Dimension(500, 50));
            lancheButton.setLayout(null);
            lancheButton.setBackground(new Color(240,240,240));
            lancheButton.addActionListener(e -> {
                int qnt = (int) pedidoLanche.get(1);
                if (qnt > 1) {
                    pedidoLanche.set(1,  qnt - 1);
                } else {
                    delivery.pedido.carrinho.remove(pedidoLanche);
                }
                recreateRequests();
            });

            JLabel nome = new JLabel(lanche.nome);
            nome.setFont(new Font("Arial", Font.BOLD,15));
            nome.setBounds(30, 0, 270, 50);
            lancheButton.add(nome);

            JLabel quantidade = new JLabel("Qnt: "+qntLanche);
            quantidade.setFont(new Font("Arial", Font.BOLD,15));
            quantidade.setBounds(250, 0, 50, 50);
            lancheButton.add(quantidade);

            JLabel preco = new JLabel("R$ "+lanche.preco);
            preco.setFont(new Font("Arial", Font.BOLD,15));
            preco.setBounds(340, 0, 100, 50);
            lancheButton.add(preco);

            JLabel button = new JLabel("-");
            button.setFont(new Font("Arial", Font.BOLD,20));
            button.setBounds(430, 0, 50, 50);
            button.setBackground(new Color(240,240,240));
            button.setBorder(null);
            button.setFocusable(false);
            lancheButton.add(button);

            panel.add(lancheButton);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            count++;
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVisible(true);
        scrollPane.setBorder(null);
        scrollPane.setBounds(125, 190, 500, 500);
        this.add(scrollPane);

        if (count == 0) {
            scrollPane.show(false);
            JLabel noItems = new JLabel("Não há items no carrinho!", SwingConstants.CENTER);
            noItems.setBounds(275, 365, 200, 50);
            noItems.setFont(new Font("Arial", Font.BOLD,15));
            this.add(noItems);
        }
    }

}
