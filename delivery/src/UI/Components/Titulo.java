package src.UI.Components;

import javax.swing.*;
import java.awt.*;

public class Titulo extends JLabel {

    public Titulo(String text, int x, int y, int width ) {
        super(text, SwingConstants.CENTER);
        this.setFont(new Font("Arial", Font.BOLD,20));
        this.setBounds(x, y, width, 40);
    }
}
