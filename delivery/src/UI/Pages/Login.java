package src.UI.Pages;

//rgb(9,8,9)
//rgb(244,0,0)
//rgb(244,78,63)
//rgb(244,121,107)
//rgb(244,153,141)
import src.UI.Components.*;
import src.UI.Layout.FormLogin;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    public Login() {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);

        FormLogin containerForm = new FormLogin();

        this.add(containerForm);
    }
}
