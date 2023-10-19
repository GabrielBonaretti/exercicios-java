package src.UI.Components;

import javax.swing.*;
import java.awt.*;

public class InputSenha extends JLabel {
    public InputSenha(String textoEmCima, int x, int y, int width) {
        this.setBounds(x, y, width, 70);

        JLabel texto = new JLabel();
        texto.setFont(new Font("Arial", Font.BOLD,15));
        texto.setText(textoEmCima);
        texto.setBounds(0,0, width, 30);

        JPasswordField input = new JPasswordField();
        input.setFont(new Font("Arial", Font.BOLD,15));
        input.setBounds(0, 30, width, 40);

        this.add(texto);
        this.add(input);
    }
}
