package src.UI.Layout;

import src.Database.Database;
import src.Entities.Lanche;
import src.Entities.Order;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SpecificOrderLayout extends JPanel {
    public Order order;
    public Delivery delivery;
    public SpecificOrderLayout(Delivery delivery) {
        this.delivery = delivery;
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);
        this.setOpaque(true);
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void createComponents() {
        this.removeAll();
        this.repaint();
        this.revalidate();

        JLabel label = new JLabel(order.id + " | " + order.date);
        label.setBounds(125,90,500,40);
        label.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label);

        JLabel linha = new JLabel();
        linha.setBounds(125, 160, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);
        this.add(linha);

        Database database = new Database();
        ArrayList<ArrayList<Object>> listItemsInOrder = database.getSpecificOrder(order.id);


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        int count = 0;
        for (ArrayList<Object> pedidoLanche: listItemsInOrder) {
            Lanche lanche = (Lanche) pedidoLanche.get(0);
            int qntLanche = (int) pedidoLanche.get(1);

            JLabel lancheButton = new JLabel();
            lancheButton.setPreferredSize(new Dimension(500, 50));
            lancheButton.setMinimumSize(new Dimension(500, 50));
            lancheButton.setMaximumSize(new Dimension(500, 50));
            lancheButton.setLayout(null);
            lancheButton.setBackground(new Color(240,240,240));
            lancheButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));



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


            panel.add(lancheButton);
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
            count++;
        }



        if (count > 0) {
            panel.setVisible(true);
            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVisible(true);
            scrollPane.setBorder(null);
            scrollPane.setBounds(125, 190, 500, 400);
            this.add(scrollPane);
        } else {
            panel.setVisible(false);
            JLabel noItems = new JLabel("Não há items no carrinho!", SwingConstants.CENTER);
            noItems.setBounds(275, 365, 200, 50);
            noItems.setFont(new Font("Arial", Font.BOLD,15));
            this.add(noItems);
        }

    }
}
