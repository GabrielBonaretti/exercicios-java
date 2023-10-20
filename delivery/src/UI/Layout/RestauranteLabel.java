package src.UI.Layout;

import javax.swing.*;
import java.awt.*;

public class RestauranteLabel extends JLabel {

    public RestauranteLabel() {
        this.setBounds(125, 150, 500, 50);
        this.setBackground(new Color(180,180,180));
        this.setOpaque(true);

        JLabel labelImage = new JLabel();
        labelImage.setBounds(25, 0, 50, 50);

        ImageIcon image = new ImageIcon("src/Resources/lunch.png");
        image.setImage(image.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));

        JLabel textName = new JLabel("Nome do restaurante");
        textName.setFont(new Font("Arial", Font.BOLD,15));
        textName.setBounds(100, 0, 150, 50);

        JLabel textPosition = new JLabel("5, 2");
        textPosition.setFont(new Font("Arial", Font.BOLD,15));
        textPosition.setBounds(300, 0, 25, 50);

        JButton buttonRestaurant = new JButton("Entrar");
        buttonRestaurant.setFont(new Font("Arial", Font.BOLD,15));
        textPosition.setBounds(350, 10, 50, 30);


        labelImage.setIcon(image);
        this.add(labelImage);
        this.add(textName);
        this.add(textPosition);
        this.add(buttonRestaurant);
    }
}
