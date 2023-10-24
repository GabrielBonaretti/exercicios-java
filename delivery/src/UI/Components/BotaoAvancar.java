package src.UI.Components;

import javax.swing.*;
import java.awt.*;

public class BotaoAvancar extends Button {
    public BotaoAvancar(String text, int y) {
        super(text);
        this.setFont(new Font("Arial", Font.BOLD,20));
        this.setFocusable(false);
        this.setBounds(150, y, 100, 40);
    }
}
