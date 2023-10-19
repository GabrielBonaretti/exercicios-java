package src.UI.Layout;

import src.UI.Components.BotaoSideBar;

import javax.swing.*;
import java.awt.*;

public class Sidebar extends JLabel {

    public Sidebar() {
        this.setBounds(0, 0, 250, 800);
        this.setBackground(new Color(200,200,200));
        this.setOpaque(true);

        BotaoSideBar botaoListarRestaurantes = new BotaoSideBar("Listar restaurantes", 0);
        BotaoSideBar botaoSair = new BotaoSideBar("Sair", 40);

        botaoListarRestaurantes.addActionListener(e -> {
            botaoListarRestaurantes.setBackground(new Color(170, 170, 170));
            botaoSair.setBackground(new Color(200, 200, 200));
        });

        botaoSair.addActionListener(e -> {
            botaoSair.setBackground(new Color(170, 170, 170));
            botaoListarRestaurantes.setBackground(new Color(200, 200, 200));
        });


        this.add(botaoListarRestaurantes);
        this.add(botaoSair);
    }
}
