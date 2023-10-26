package src.UI.Layout;

import src.Database.Database;
import src.Entities.Lanche;
import src.Entities.Order;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoricLayout extends JPanel {
    public Delivery delivery;
    public HistoricLayout(Delivery delivery) {
        this.delivery = delivery;
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);
        this.setOpaque(true);
        createComponents();
    }

    public void createComponents() {
        this.removeAll();
        this.repaint();
        this.revalidate();

        JLabel label = new JLabel("Historico");
        label.setBounds(125,90,200,40);
        label.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label);

        JLabel linha = new JLabel();
        linha.setBounds(125, 160, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);
        this.add(linha);

        Database database = new Database();
        ArrayList<Order> allOrders = database.getAllOrders();

        if (!allOrders.isEmpty()) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.setVisible(true);

            for (Order order: allOrders) {
                JLabel text = new JLabel();
                text.setPreferredSize(new Dimension(500, 50));
                text.setMinimumSize(new Dimension(500, 50));
                text.setMaximumSize(new Dimension(500, 50));
                text.setLayout(null);
                text.setOpaque(true);
                text.setBackground(new Color(180,180,180));;

                JLabel nome = new JLabel(String.valueOf(order.id));
                nome.setFont(new Font("Arial", Font.BOLD,15));
                nome.setBounds(30, 0, 25, 50);
                text.add(nome);

                JLabel data = new JLabel(order.date);
                data.setFont(new Font("Arial", Font.BOLD,15));
                data.setBounds(90, 0, 200, 50);
                text.add(data);

                JLabel preco = new JLabel("Preço total: R$ "+order.totalPrice);
                preco.setFont(new Font("Arial", Font.BOLD,15));
                preco.setBounds(250, 0, 200, 50);
                text.add(preco);

                JButton button = new JButton("...");
                button.setFont(new Font("Arial", Font.BOLD,15));
                button.setBounds(440, 10, 50, 30);
                button.addActionListener(e -> {
                    this.delivery.historicLayout.setVisible(false);
                    this.delivery.specificOrderLayout.setOrder(order);
                    this.delivery.specificOrderLayout.createComponents();
                    this.delivery.specificOrderLayout.setVisible(true);
                });
                text.add(button);

                panel.add(text);
                panel.add(Box.createRigidArea(new Dimension(0, 20)));
            }

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVisible(true);
            scrollPane.setBorder(null);
            scrollPane.setBounds(125, 200, 500, 500);
            this.add(scrollPane);
        } else {
            JLabel noItems = new JLabel("Não há pedidos no restaurante!", SwingConstants.CENTER);
            noItems.setBounds(225, 365, 300, 50);
            noItems.setFont(new Font("Arial", Font.BOLD,15));
            this.add(noItems);
        }
    }
}
