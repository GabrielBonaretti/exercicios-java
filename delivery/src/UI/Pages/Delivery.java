package src.UI.Pages;

import src.Entities.Pedido;
import src.UI.Layout.*;

import javax.swing.*;
import java.awt.*;

public class Delivery extends JPanel {
    public Pedido pedido;
    public ListRestaurantLayout listRestaurantLayout;
    public OrderLayout orderLayout;
    public MyRestaurantLayout myRestaurantLayout;
    public RestaurantSpecificPage restaurantSpecificPage;
    public Delivery() {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);

        this.pedido = new Pedido();

        Sidebar sidebar = new Sidebar(this);
        this.add(sidebar);

        this.listRestaurantLayout = new ListRestaurantLayout(this);
        this.add(listRestaurantLayout);
        this.listRestaurantLayout.show(true);

        this.orderLayout = new OrderLayout(this);
        this.add(orderLayout);
        this.orderLayout.show(false);

        this.myRestaurantLayout = new MyRestaurantLayout();
        this.add(myRestaurantLayout);
        this.myRestaurantLayout.show(false);

    }
}
