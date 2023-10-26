package src.UI.Layout;

import src.Database.Database;
import src.UI.Components.*;
import src.UI.Tela;

import javax.swing.*;
import java.awt.*;

public class FormLogin extends JLabel {
    private boolean isRestaurant = false;
    private final Tela tela;

    public FormLogin(Tela tela) {
        this.tela = tela;
        this.setBounds(300, 150, 400, 450);
        this.setBackground(new Color(170,170,170));
        this.setOpaque(true);

        createaComponents();
    }


    public void createaComponents() {
        this.removeAll();
        this.repaint();
        this.revalidate();

        String textTitle;

        if (!isRestaurant) {
            textTitle = "Login usuário";
        } else {
            textTitle = "Login restaurante";
        }

        Titulo titulo = new Titulo(textTitle, 100, 90, 200);

        JCheckBox restaurantCheckBox = new JCheckBox("Restaurante");
        restaurantCheckBox.setSelected(isRestaurant);
        restaurantCheckBox.setBounds(225, 25, 100, 40);
        restaurantCheckBox.setBackground(new Color(170,170,170));
        restaurantCheckBox.setOpaque(true);
        restaurantCheckBox.setFocusable(false);
        restaurantCheckBox.addActionListener(e -> {
            isRestaurant = !isRestaurant;
            createaComponents();
        });

        Input inputNome = new Input("Nome", 75, 150, 250);
        InputSenha inputSenha = new InputSenha("Senha", 75, 220, 250);

        JButton botaoCadastrar = new JButton("Não tem uma conta? Cadastre-se!");
        botaoCadastrar.setFont(new Font("Arial", Font.BOLD,10));
        botaoCadastrar.setBackground(new Color(170,170,170));
        botaoCadastrar.setBorder(null);
        botaoCadastrar.setFocusable(false);
        botaoCadastrar.setBounds(150, 290, 175, 20);
        botaoCadastrar.addActionListener(e -> {
            this.tela.login.show(false);
            this.tela.cadastro.show(true);

            inputNome.clearContent();
            inputSenha.clearContent();
        });

        JButton avancar = new JButton("Entrar");
        avancar.setFont(new Font("Arial", Font.BOLD,20));
        avancar.setFocusable(false);
        avancar.setBounds(150, 350, 100, 40);
        avancar.addActionListener(e -> {
            String name = inputNome.inputContent();
            String password = inputSenha.inputContent();

            Database database = new Database();
            int userID;

            if (!isRestaurant) {
                userID = database.verifyAcountUser(name,password);
                this.tela.delivery.listRestaurantLayout.show(true);
                this.tela.delivery.orderLayout.show(false);
                this.tela.delivery.myRestaurantLayout.show(false);
            } else {
                userID = database.verifyAcountRestaurant(name,password);
                this.tela.delivery.listRestaurantLayout.show(false);
                this.tela.delivery.orderLayout.show(false);
                this.tela.delivery.myRestaurantLayout.show(true);
            }

            if (userID > 0) {
                this.tela.login.show(false);
                this.tela.delivery.show(true);
            }

            this.tela.delivery.id = userID;
            this.tela.delivery.sidebar.createComponents(isRestaurant);

            if (!isRestaurant) {
                this.tela.delivery.listRestaurantLayout.createComponents();
            } else {
                this.tela.delivery.myRestaurantLayout.createComponents();
            }
            inputNome.clearContent();
            inputSenha.clearContent();
        });

        this.add(titulo);
        this.add(inputNome);
        this.add(inputSenha);
        this.add(botaoCadastrar);
        this.add(avancar);
        this.add(restaurantCheckBox);

    }

}
