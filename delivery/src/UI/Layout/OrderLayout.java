package src.UI.Layout;

import src.Entities.Lanche;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;

public class OrderLayout extends JLabel {
    public Delivery delivery;
    public OrderLayout(Delivery delivery) {
        this.delivery = delivery;
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setOpaque(true);
        this.setLayout(null);
    }

    public void recreateRequests() {
        this.removeAll();
        this.repaint();
        this.revalidate();

        int count = 0;
        for (Lanche lanche: this.delivery.pedido.carrinho) {
            JLabel texto = new JLabel(lanche.nome);
            texto.setBounds(0, count*50, 100, 30);
            this.add(texto);
            count++;
        }
    }

}
