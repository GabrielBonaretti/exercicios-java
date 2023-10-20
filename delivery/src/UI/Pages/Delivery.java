package src.UI.Pages;

import src.UI.Layout.*;

import javax.swing.*;
import java.awt.*;

public class Delivery extends JPanel {

    public int choosedPanel = 0;


    public Delivery() {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);

        Sidebar sidebar = new Sidebar(this);
        this.add(sidebar);

        switch (choosedPanel) {
            case 0 -> this.add(new ListRestaurantLayout());
            case 1 -> this.add(new OrderLayout());
            case 2 -> this.add(new MyRestaurantLayout());
        }
    }
}
