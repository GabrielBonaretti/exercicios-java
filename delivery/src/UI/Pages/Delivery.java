package src.UI.Pages;

import src.Entities.Pedido;
import src.Entities.Restaurante;
import src.Entities.Usuario;
import src.UI.Layout.*;
import src.UI.Tela;

import javax.swing.*;
import java.awt.*;

public class Delivery extends JPanel {
    public Pedido pedido;
    public Sidebar sidebar;
    public ListRestaurantLayout listRestaurantLayout;
    public OrderLayout orderLayout;
    public MyRestaurantLayout myRestaurantLayout;
    public RestaurantSpecificPage restaurantSpecificPage;
    public int id;

    public Delivery(Tela tela) {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);

        this.pedido = new Pedido();

        this.sidebar = new Sidebar(this, tela);
        this.add(sidebar);

        this.listRestaurantLayout = new ListRestaurantLayout(this);
        this.add(listRestaurantLayout);
        this.listRestaurantLayout.setVisible(false);

        this.orderLayout = new OrderLayout(this);
        this.add(orderLayout);
        this.listRestaurantLayout.setVisible(false);

        this.myRestaurantLayout = new MyRestaurantLayout(this);
        this.add(myRestaurantLayout);
        this.listRestaurantLayout.setVisible(false);

        this.restaurantSpecificPage = new RestaurantSpecificPage(this);
        this.add(restaurantSpecificPage);
        this.restaurantSpecificPage.setVisible(false);
    }
}
