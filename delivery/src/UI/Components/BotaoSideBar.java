package src.UI.Components;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class BotaoSideBar extends JButton {

    public BotaoSideBar(String text, int y) {
        super(text);
        this.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));
        this.setFocusable(false);
        this.setBackground(new Color(200,200,200));
        this.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));
        this.setBounds(0, y, 250, 40);
    }
}
