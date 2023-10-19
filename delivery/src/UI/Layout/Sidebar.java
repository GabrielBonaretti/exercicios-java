package src.UI.Layout;

import src.UI.Components.BotaoSideBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Sidebar extends JLabel {
    public boolean isRestaurante = true;
    public ArrayList<BotaoSideBar> listaBotoes = new ArrayList<BotaoSideBar>();

    public Sidebar() {
        this.setBounds(0, 0, 250, 800);
        this.setBackground(new Color(200,200,200));
        this.setOpaque(true);

        BotaoSideBar botaoListarRestaurantes = new BotaoSideBar("Listar restaurantes", 0, "src/Resources/lista.png");
        botaoListarRestaurantes.setBackground(new Color(170, 170, 170));
        BotaoSideBar carrinho = new BotaoSideBar("Carrinho", 40, "src/Resources/cart.png");
        BotaoSideBar botaoSair;
        BotaoSideBar botaoMeuRestaurantes;

        if (isRestaurante) {
            botaoMeuRestaurantes = new BotaoSideBar("Meu restaurante", 80, "src/Resources/loja.png");
            botaoSair = new BotaoSideBar("Sair", 120, "src/Resources/logout.png");
            listaBotoes.add(botaoMeuRestaurantes);
            this.add(botaoMeuRestaurantes);
        } else {
            botaoSair = new BotaoSideBar("Sair", 80, "src/Resources/logout.png");
        }

        listaBotoes.add(carrinho);
        listaBotoes.add(botaoListarRestaurantes);
        listaBotoes.add(botaoSair);

        for (BotaoSideBar botao: listaBotoes) {
            botao.addActionListener(e -> {
                limpandoCor();
                botao.setBackground(new Color(170, 170, 170));
            });
        }

        this.add(botaoListarRestaurantes);
        this.add(carrinho);
        this.add(botaoSair);
    }

    public void limpandoCor() {
        for (BotaoSideBar botao: listaBotoes) {
            botao.setBackground(new Color(200, 200, 200));
        }
    }
}
