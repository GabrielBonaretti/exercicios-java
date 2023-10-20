package src.UI.Layout;

import javax.swing.*;
import java.awt.*;

public class OrderLayout extends JLabel {
    public OrderLayout() {
        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setOpaque(true);
        this.setText("order");
    }
}
