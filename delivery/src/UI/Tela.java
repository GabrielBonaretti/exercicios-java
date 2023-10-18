package src.UI;

import javax.swing.*;

public class Tela extends JFrame{

    public Tela() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setResizable(false);
        this.setLayout(null);

        this.add(new Login());
//        this.add(new Cadastro());


        this.setVisible(true);
    }
}
