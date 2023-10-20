package src.UI.Layout;

import src.Entities.Endereco;
import src.Entities.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListarRestaurantes extends JLabel {
    private ArrayList<Restaurante> listRestaurants = new ArrayList<Restaurante>();
    private int countPage;

    public ListarRestaurantes() {
        Endereco endereco1 = new Endereco(4, 2);
        Restaurante restaurante1 = new Restaurante("Restaurante1", endereco1);
        this.listRestaurants.add(restaurante1);

        Restaurante restaurante2 = new Restaurante("Restaurante2", endereco1);
        this.listRestaurants.add(restaurante2);

        Restaurante restaurante3 = new Restaurante("Restaurante3", endereco1);
        this.listRestaurants.add(restaurante3);

        Restaurante restaurante4 = new Restaurante("Restaurante4", endereco1);
        this.listRestaurants.add(restaurante4);

        Restaurante restaurante5 = new Restaurante("Restaurante1", endereco1);
        this.listRestaurants.add(restaurante5);

        Restaurante restaurante6 = new Restaurante("Restaurante2", endereco1);
        this.listRestaurants.add(restaurante6);

        Restaurante restaurante7 = new Restaurante("Restaurante3", endereco1);
        this.listRestaurants.add(restaurante7);

        Restaurante restaurante8 = new Restaurante("Restaurante4", endereco1);
        this.listRestaurants.add(restaurante8);


        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setOpaque(true);

        JTextField inputSearch = new JTextField();
        inputSearch.setBounds(225,40,300,40);

        JLabel linha = new JLabel();
        linha.setBounds(125, 110, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);


        for(countPage = 0; countPage < 6; countPage++) {
            Restaurante restaurante = listRestaurants.get(countPage);
            String restaurantPosition = restaurante.localizacao.posicaoX+", "+restaurante.localizacao.posicaoY;
            RestauranteLabel restauranteLabel = new RestauranteLabel(restaurante.nome, restaurantPosition, 140 + countPage*70);
            this.add(restauranteLabel);
        }

        JButton esquerda = new JButton("<");
        esquerda.setFont(new Font("Arial", Font.BOLD,25));
        esquerda.setBounds(320, 570, 50, 50);
        esquerda.setFocusable(false);

        JButton direita = new JButton(">");
        direita.setFont(new Font("Arial", Font.BOLD,25));
        direita.setBounds(380, 570, 50, 50);
        direita.setFocusable(false);

        this.add(inputSearch);
        this.add(linha);
        this.add(esquerda);
        this.add(direita);
    }
}
