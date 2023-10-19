package src.UI.Layout;

import src.Entities.Restaurante;

import javax.swing.*;
import java.awt.*;

public class ListarRestaurantes extends JLabel {
    public ListarRestaurantes() {
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setOpaque(true);

        JTextField inputSearch = new JTextField();
        inputSearch.setBounds(225,40,300,40);

        JLabel linha = new JLabel();
        linha.setBounds(125, 120, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);

        RestauranteLabel restaurando = new RestauranteLabel();


        this.add(inputSearch);
        this.add(restaurando);
        this.add(linha);
    }
}
