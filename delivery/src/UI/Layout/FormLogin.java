package src.UI.Layout;

import src.UI.Components.*;

import javax.swing.*;
import java.awt.Color;
public class FormLogin extends JLabel {
    public FormLogin() {
        this.setBounds(300, 150, 400, 450);
        this.setBackground(new Color(170,170,170));
        this.setOpaque(true);

        Titulo titulo = new Titulo("Login", 172, 90, 55);

        JLabel inputNome = new Input("Nome", 75, 150, 250);
        JLabel inputSenha = new InputSenha("Senha", 75, 220, 250);

        BotaoLoginCadastrar botaoCadastrar = new BotaoLoginCadastrar("Não tem uma conta? Cadastre-se!", 150, 290);

        BotaoAvancar avancar = new BotaoAvancar("Entrar", 350);

        this.add(titulo);
        this.add(inputNome);
        this.add(inputSenha);
        this.add(botaoCadastrar);
        this.add(avancar);
    }

}
