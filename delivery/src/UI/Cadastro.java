package src.UI;

import javax.swing.*;
import java.awt.*;

public class Cadastro extends JPanel{
    public Cadastro() {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(null);

        JLabel containerForm = new JLabel();
        containerForm.setBounds(300, 150, 400, 450);
        containerForm.setBackground(new Color(170,170,170));
        containerForm.setOpaque(true);

        JLabel titulo = new JLabel();
        titulo.setFont(new Font("Arial", Font.BOLD,20));
        titulo.setText("Cadastrar");
        titulo.setBounds(150, 25, 100, 40);

        JLabel inputNome = new Input("Nome", 75, 75, 250);
        JLabel inputCPF = new Input("CPF", 75, 145, 250);
        JLabel inputPosicaoX = new Input("Posição (X)", 75, 215, 115);
        JLabel inputPosicaoY = new Input("Posição (Y)", 210, 215, 115);
        JLabel inputSenha = new InputSenha("Senha", 75, 285, 250);

        BotaoLoginCadastrar botaoLogin = new BotaoLoginCadastrar("Já tem uma conta? Entre!", 150, 355);

        JButton Avancar = new JButton();
        Avancar.setText("Entrar");
        Avancar.setFont(new Font("Arial", Font.BOLD,20));
        Avancar.setFocusable(false);
        Avancar.setBounds(150, 375, 100, 40);

        containerForm.add(titulo);
        containerForm.add(inputNome);
        containerForm.add(inputCPF);
        containerForm.add(inputPosicaoX);
        containerForm.add(inputPosicaoY);
        containerForm.add(inputSenha);
        containerForm.add(botaoLogin);
        containerForm.add(Avancar);

        this.add(containerForm);
    }
}
