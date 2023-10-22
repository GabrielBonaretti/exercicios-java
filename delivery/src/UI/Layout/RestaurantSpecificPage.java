package src.UI.Layout;

import src.Entities.Lanche;
import src.Entities.Restaurante;
import src.UI.Pages.Delivery;

import javax.swing.*;
import java.awt.*;

public class RestaurantSpecificPage extends JPanel {
    public RestaurantSpecificPage(Restaurante restaurante, Delivery delivery) {
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);
        this.setOpaque(true);

        JLabel label = new JLabel(restaurante.nome);
        label.setBounds(125,90,200,40);
        label.setFont(new Font("Arial", Font.BOLD,30));
        this.add(label);

        JLabel linha = new JLabel();
        linha.setBounds(125, 160, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);
        this.add(linha);

        int count = 0;
        for (Lanche lanche: restaurante.listaLanches) {
            LancheLabel lancheLabel = new LancheLabel(190 + count * 70, lanche, delivery, restaurante);
            this.add(lancheLabel);
            count++;
        }
    }
}
