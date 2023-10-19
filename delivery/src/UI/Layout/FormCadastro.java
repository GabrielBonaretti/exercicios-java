package src.UI.Layout;

import src.UI.Components.*;

import javax.swing.*;
import java.awt.*;

public class FormCadastro extends JLabel {
    public FormCadastro() {
        this.setBounds(300, 150, 400, 450);
        this.setBackground(new Color(170,170,170));
        this.setOpaque(true);

        Titulo titulo = new Titulo("Cadastrar", 150, 25, 100);

        JLabel inputNome = new Input("Nome", 75, 75, 250);
        JLabel inputCPF = new Input("CPF", 75, 145, 250);
        JLabel inputPosicaoX = new Input("Posição (X)", 75, 215, 115);
        JLabel inputPosicaoY = new Input("Posição (Y)", 210, 215, 115);
        JLabel inputSenha = new InputSenha("Senha", 75, 285, 250);

        BotaoLoginCadastrar botaoLogin = new BotaoLoginCadastrar("Já tem uma conta? Entre!", 150, 355);

        BotaoAvancar cadastrar = new BotaoAvancar("Cadastrar", 375);

        this.add(titulo);
        this.add(inputNome);
        this.add(inputCPF);
        this.add(inputPosicaoX);
        this.add(inputPosicaoY);
        this.add(inputSenha);
        this.add(botaoLogin);
        this.add(cadastrar);
    }
}
