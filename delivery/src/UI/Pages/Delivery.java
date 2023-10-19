package src.UI.Pages;

import src.UI.Layout.Sidebar;

import javax.swing.*;
import java.awt.*;

public class Delivery extends JPanel {
    public Delivery() {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);

        this.add(new Sidebar());
    }
}
