package src.UI.Layout;

import src.Database.Database;
import src.UI.Components.*;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class FormCadastro extends JLabel {
    boolean isRestaurant = false;
    public FormCadastro() {
        this.setBounds(300, 150, 400, 450);
        this.setBackground(new Color(170,170,170));
        this.setOpaque(true);

        createaComponents();
    }

    public void createaComponents() {
        this.removeAll();
        this.repaint();
        this.revalidate();

        Titulo titulo = new Titulo("Cadastrar", 75, 25, 100);

        JCheckBox restaurantCheckBox = new JCheckBox("Restaurante");
        restaurantCheckBox.setBounds(225, 25, 100, 40);
        restaurantCheckBox.setBackground(new Color(170,170,170));
        restaurantCheckBox.setOpaque(true);
        restaurantCheckBox.setFocusable(false);
        restaurantCheckBox.addActionListener(e -> {
            isRestaurant = !isRestaurant;
            createaComponents();
        });

        Input inputNome = new Input("Nome", 75, 75, 250);
        Input inputCPF;
        if (!isRestaurant) {
            inputCPF = new Input("CPF", 75, 145, 250);
        } else {
            inputCPF = new Input("CNPJ", 75, 145, 250);
        }
        Input inputPosicaoX = new Input("Posição (X)", 75, 215, 115);
        Input inputPosicaoY = new Input("Posição (Y)", 210, 215, 115);
        InputSenha inputSenha = new InputSenha("Senha", 75, 285, 250);

        BotaoLoginCadastrar botaoLogin = new BotaoLoginCadastrar("Já tem uma conta? Entre!", 150, 355);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setFont(new Font("Arial", Font.BOLD,20));
        cadastrar.setFocusable(false);
        cadastrar.setBounds(150, 375, 100, 40);
        cadastrar.addActionListener(e -> {
            String name = inputNome.inputContent();
            String cpfCnpj = inputCPF.inputContent();
            int posicaoX = Integer.parseInt(inputPosicaoX.inputContent());
            int posicaoY = Integer.parseInt(inputPosicaoY.inputContent());
            String senha = inputSenha.inputContent();

            Database database = new Database();

            if (!isRestaurant) {
                database.createUser(
                        name,
                        cpfCnpj,
                        posicaoX,
                        posicaoY,
                        senha
                );
            } else {
                database.createRestaurant(
                        name,
                        cpfCnpj,
                        posicaoX,
                        posicaoY,
                        senha
                );
            }

            inputNome.clearContent();
            inputCPF.clearContent();
            inputPosicaoX.clearContent();
            inputPosicaoY.clearContent();
            inputSenha.clearContent();

        });

        this.add(titulo);
        this.add(restaurantCheckBox);
        this.add(inputNome);
        this.add(inputCPF);
        this.add(inputPosicaoX);
        this.add(inputPosicaoY);
        this.add(inputSenha);
        this.add(botaoLogin);
        this.add(cadastrar);
    }
}
