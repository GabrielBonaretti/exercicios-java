package src.UI.Layout;

import src.Database.Database;
import src.Entities.Endereco;
import src.Entities.Lanche;
import src.Entities.Restaurante;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyRestaurantLayout extends JPanel {
    public Delivery delivery;
    public MyRestaurantLayout(Delivery delivery) {
        this.delivery = delivery;
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);
        this.setOpaque(true);
    }

    public void createComponents() {
        this.removeAll();
        this.revalidate();
        this.repaint();

        Database database = new Database();
        Restaurante restaurante = database.getRestaurant(this.delivery.id);
        restaurante.setId(this.delivery.id);
        restaurante.setListaLanches();

        JLabel label = new JLabel(restaurante.nome);
        label.setBounds(125,90,450,40);
        label.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label);

        JLabel linha = new JLabel();
        linha.setBounds(125, 160, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);
        this.add(linha);


        JLabel newFood = new JLabel("New Food: ");
        newFood.setBounds(125, 170, 100, 40);
        newFood.setFont(new Font("Arial", Font.BOLD,15));
        this.add(newFood);

        JLabel name = new JLabel("name ");
        name.setBounds(225, 170, 50, 40);
        name.setFont(new Font("Arial", Font.BOLD,15));
        this.add(name);

        JTextField nameFoodInput = new JTextField();
        nameFoodInput.setBounds(275, 170, 100, 40);
        nameFoodInput.setFont(new Font("Arial", Font.BOLD,15));
        this.add(nameFoodInput);

        JLabel price = new JLabel("price ");
        price.setBounds(400, 170, 50, 40);
        price.setFont(new Font("Arial", Font.BOLD,15));
        this.add(price);

        JTextField priceFoodInput = new JTextField();
        priceFoodInput.setBounds(450, 170, 100, 40);
        priceFoodInput.setFont(new Font("Arial", Font.BOLD,15));
        this.add(priceFoodInput);

        JButton addFood = new JButton("+");
        addFood.setBounds(575, 170, 50, 40);
        addFood.addActionListener(e -> {
            String nome = nameFoodInput.getText();
            Double preco = Double.valueOf(priceFoodInput.getText());

            Lanche lanche = new Lanche(nome, preco);
            restaurante.adicionarLanche(lanche);

            createComponents();
        });
        this.add(addFood);

        JLabel linha2 = new JLabel();
        linha2.setBounds(125, 220, 500, 1);
        linha2.setBackground(new Color(180,180,180));
        linha2.setOpaque(true);
        this.add(linha2);

        if (restaurante.listaLanches.toArray().length > 0) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.setVisible(true);

            for (Lanche lanche: restaurante.listaLanches) {
                JLabel lancheButton = new JLabel();
                lancheButton.setPreferredSize(new Dimension(500, 50));
                lancheButton.setMinimumSize(new Dimension(500, 50));
                lancheButton.setMaximumSize(new Dimension(500, 50));
                lancheButton.setLayout(null);
                lancheButton.setOpaque(true);
                lancheButton.setBackground(new Color(180,180,180));


                JLabel nome = new JLabel(lanche.nome);
                nome.setFont(new Font("Arial", Font.BOLD,15));
                nome.setBounds(30, 0, 270, 50);
                lancheButton.add(nome);

                JLabel preco = new JLabel("R$ "+lanche.preco);
                preco.setFont(new Font("Arial", Font.BOLD,15));
                preco.setBounds(340, 0, 100, 50);
                lancheButton.add(preco);

                JButton button = new JButton("-");
                button.setFont(new Font("Arial", Font.BOLD,20));
                button.setBounds(430, 0, 50, 50);
                button.setBackground(new Color(180,180,180));
                button.setBorder(null);
                button.setFocusable(false);
                button.addActionListener(e -> {
                    restaurante.removerLanche(lanche.id);
                    createComponents();
                });

                lancheButton.add(button);

                panel.add(lancheButton);
                panel.add(Box.createRigidArea(new Dimension(0, 20)));
            }

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setVisible(true);
            scrollPane.setBorder(null);
            scrollPane.setBounds(125, 230, 500, 400);
            this.add(scrollPane);
        } else {
            JLabel noItems = new JLabel("Não há pedidos no restaurante!", SwingConstants.CENTER);
            noItems.setBounds(225, 365, 300, 50);
            noItems.setFont(new Font("Arial", Font.BOLD,15));
            this.add(noItems);
        }
    }
}
