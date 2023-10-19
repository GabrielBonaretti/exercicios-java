package src.UI.Components;

import javax.swing.*;
import java.awt.*;

public class Titulo extends JLabel {

    public Titulo(String text, int x, int y, int width ) {
        this.setFont(new Font("Arial", Font.BOLD,20));
        this.setText(text);
        this.setBounds(x, y, width, 40);
    }
}
