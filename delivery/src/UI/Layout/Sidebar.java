package src.UI.Layout;

import src.UI.Components.BotaoSideBar;
import src.UI.Pages.Delivery;
import src.UI.Tela;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Sidebar extends JLabel {
    private ArrayList<BotaoSideBar> listaBotoes = new ArrayList<BotaoSideBar>();
    public Delivery delivery;
    public Tela tela;
    public Sidebar(Delivery delivey, Tela tela) {
        this.setBounds(0, 0, 250, 800);
        this.setBackground(new Color(200,200,200));
        this.setOpaque(true);
        this.delivery = delivey;
        this.tela = tela;
        createComponents(false);
    }

    public void limpandoCor() {
        for (BotaoSideBar botao: listaBotoes) {
            botao.setBackground(new Color(200, 200, 200));
        }
    }

    public void createComponents(boolean isRestaurante) {
        this.removeAll();
        this.repaint();
        this.revalidate();

        BotaoSideBar botaoSair;
        BotaoSideBar botaoMeuRestaurantes;
        BotaoSideBar botaoListarRestaurantes;
        BotaoSideBar carrinho;

        if (isRestaurante) {
            botaoMeuRestaurantes = new BotaoSideBar("Meu restaurante", 0, "src/Resources/loja.png",2);
            botaoSair = new BotaoSideBar("Sair", 40, "src/Resources/logout.png", 4);
            listaBotoes.add(botaoMeuRestaurantes);
            listaBotoes.add(botaoSair);
            this.add(botaoMeuRestaurantes);
        } else {
            botaoListarRestaurantes = new BotaoSideBar("Listar restaurantes", 0, "src/Resources/lista.png",0);
            botaoListarRestaurantes.setBackground(new Color(170, 170, 170));
            carrinho = new BotaoSideBar("Carrinho", 40, "src/Resources/cart.png",1);
            botaoSair = new BotaoSideBar("Sair", 80, "src/Resources/logout.png",4);
            listaBotoes.add(carrinho);
            listaBotoes.add(botaoListarRestaurantes);
            listaBotoes.add(botaoSair);
            this.add(botaoListarRestaurantes);
            this.add(carrinho);
        }

        for (BotaoSideBar botao: listaBotoes) {
            botao.addActionListener(e -> {
                limpandoCor();
                botao.setBackground(new Color(170, 170, 170));

                switch (botao.buttonChoice) {
                    case 0:
                        this.delivery.listRestaurantLayout.show(true);
                        this.delivery.orderLayout.show(false);
                        this.delivery.myRestaurantLayout.show(false);
                        if (this.delivery.restaurantSpecificPage != null) {
                            this.delivery.restaurantSpecificPage.show(false);
                        }
                        break;
                    case 1:
                        this.delivery.listRestaurantLayout.show(false);
                        this.delivery.orderLayout.show(true);
                        this.delivery.myRestaurantLayout.show(false);
                        if (this.delivery.restaurantSpecificPage != null) {
                            this.delivery.restaurantSpecificPage.show(false);
                        }
                        break;
                    case 2:
                        this.delivery.listRestaurantLayout.show(false);
                        this.delivery.orderLayout.show(false);
                        this.delivery.myRestaurantLayout.show(true);
                        if (this.delivery.restaurantSpecificPage != null) {
                            this.delivery.restaurantSpecificPage.show(false);
                        }
                        break;
                    case 4:
                        this.tela.delivery.show(false);
                        this.tela.login.show(true);
                        this.delivery.pedido.carrinho.clear();
                        this.delivery.orderLayout.recreateRequests();
                        break;
                }
            });
        }


        this.add(botaoSair);
    }

}
