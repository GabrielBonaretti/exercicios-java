package src.UI.Pages;

import src.UI.Layout.FormCadastro;
import src.UI.Tela;

import javax.swing.*;
import java.awt.*;

public class Cadastro extends JPanel{
    public Cadastro(Tela tela) {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setLayout(null);

        FormCadastro containerForm = new FormCadastro(tela);

        this.add(containerForm);
    }
}
