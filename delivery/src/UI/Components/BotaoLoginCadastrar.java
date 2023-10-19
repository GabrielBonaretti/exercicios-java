package src.UI.Components;

import javax.swing.*;
import java.awt.*;

public class BotaoLoginCadastrar extends JButton{
    public BotaoLoginCadastrar(String text, int x, int y) {
        this.setText(text);
        this.setFont(new Font("Arial", Font.BOLD,10));
        this.setBackground(new Color(170,170,170));
        this.setBorder(null);
        this.setFocusable(false);
        this.setBounds(x, y, 175, 20);

    }
}
