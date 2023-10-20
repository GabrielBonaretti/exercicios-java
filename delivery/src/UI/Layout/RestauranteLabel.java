package src.UI.Layout;

import javax.swing.*;
import java.awt.*;

public class RestauranteLabel extends JLabel {

    public RestauranteLabel(String restaurantName, String restaurantPosition, int y) {
        this.setBounds(0, y, 500, 50);
        this.setBackground(new Color(180,180,180));
        this.setOpaque(true);

        JLabel labelImage = new JLabel();
        labelImage.setBounds(35, 0, 50, 50);

        ImageIcon image = new ImageIcon("src/Resources/lunch.png");
        image.setImage(image.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));

        JLabel textName = new JLabel(restaurantName);
        textName.setFont(new Font("Arial", Font.BOLD,15));
        textName.setBounds(110, 0, 150, 50);

        JLabel textPosition = new JLabel(restaurantPosition);
        textPosition.setFont(new Font("Arial", Font.BOLD,15));
        textPosition.setBounds(295, 0, 25, 50);

        JButton buttonRestaurant = new JButton("Entrar");
        buttonRestaurant.setFont(new Font("Arial", Font.BOLD,15));
        buttonRestaurant.setBounds(360, 10, 100, 30);
        buttonRestaurant.setFocusable(false);


        labelImage.setIcon(image);
        this.add(labelImage);
        this.add(textName);
        this.add(textPosition);
        this.add(buttonRestaurant);
    }
}
