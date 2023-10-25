package src.UI.Pages;

import src.UI.Components.*;
import src.UI.Layout.FormLogin;
import src.UI.Tela;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    public Login(Tela tela) {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);

        FormLogin containerForm = new FormLogin(tela);

        this.add(containerForm);
    }
}
