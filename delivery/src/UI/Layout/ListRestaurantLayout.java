package src.UI.Layout;

import src.Entities.Endereco;
import src.Entities.Restaurante;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListRestaurantLayout extends JLabel {
    private ArrayList<Restaurante> listRestaurants = new ArrayList<Restaurante>();
    private ArrayList<Restaurante> listFilteredRestaurants = new ArrayList<Restaurante>();
    private JLabel restaurantsListLabel;
    private JButton prev;
    private JButton next;
    private int countPage;

    public ListRestaurantLayout() {
        Endereco endereco1 = new Endereco(4, 2);
        Restaurante restaurante1 = new Restaurante("a", endereco1);
        this.listRestaurants.add(restaurante1);

        Restaurante restaurante2 = new Restaurante("b", endereco1);
        this.listRestaurants.add(restaurante2);

        Restaurante restaurante3 = new Restaurante("c", endereco1);
        this.listRestaurants.add(restaurante3);

        Restaurante restaurante4 = new Restaurante("d", endereco1);
        this.listRestaurants.add(restaurante4);

        Restaurante restaurante5 = new Restaurante("e", endereco1);
        this.listRestaurants.add(restaurante5);

        Restaurante restaurante6 = new Restaurante("f", endereco1);
        this.listRestaurants.add(restaurante6);

        Restaurante restaurante7 = new Restaurante("g", endereco1);
        this.listRestaurants.add(restaurante7);

        Restaurante restaurante8 = new Restaurante("Restaurante4", endereco1);
        this.listRestaurants.add(restaurante8);

        listFilteredRestaurants = (ArrayList<Restaurante>) listRestaurants.stream().collect(Collectors.toList());;

        this.setBounds(250, 0, 750, 800);
        this.setBackground(new Color(240,240,240));
        this.setOpaque(true);

        JTextField inputSearch = new JTextField();
        inputSearch.setBounds(225,90,250,40);

        JButton search = new JButton();
        search.setBounds(485, 90, 40, 40);
        search.addActionListener(e -> searchList(inputSearch.getText()));
        ImageIcon imageButton = new ImageIcon("src/Resources/search.png");
        imageButton.setImage(imageButton.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT));
        search.setIcon(imageButton);
        search.setFocusable(false);

        JLabel linha = new JLabel();
        linha.setBounds(125, 160, 500, 1);
        linha.setBackground(new Color(180,180,180));
        linha.setOpaque(true);

        restaurantsListLabel = new JLabel();
        restaurantsListLabel.setBounds(125, 190, 600, 600);

        setRestaurants();

        prev = new JButton("<");
        prev.setFont(new Font("Arial", Font.BOLD,25));
        prev.setBounds(320, 620, 50, 50);
        prev.setFocusable(false);

        prev.addActionListener(e -> {
            countPage --;
            updateListLabel();
        });

        next = new JButton(">");
        next.setFont(new Font("Arial", Font.BOLD,25));
        next.setBounds(380, 620, 50, 50);
        next.addActionListener(e -> {
            countPage ++;
            updateListLabel();
        });

        verifyButtons();

        this.add(restaurantsListLabel);
        this.add(search);
        this.add(inputSearch);
        this.add(linha);
        this.add(prev);
        this.add(next);
    }

    public void setRestaurants() {
        for(int i = 0; i < 6; i++) {
            try {
                Restaurante restaurante = listFilteredRestaurants.get(i + 6*countPage);
                String restaurantPosition = restaurante.localizacao.posicaoX+", "+restaurante.localizacao.posicaoY;
                RestauranteLabel restauranteLabel = new RestauranteLabel(restaurante.nome, restaurantPosition, i*70);
                restaurantsListLabel.add(restauranteLabel);
            } catch (Exception e) {
                break;
            }
        }
    }

    public void verifyButtons() {

        if (countPage > 0 && listFilteredRestaurants.toArray().length / 6 != countPage) {
            prev.setEnabled(true);
            next.setEnabled(true);
        } else if (countPage > 0 && listFilteredRestaurants.toArray().length / 6 == countPage) {
            prev.setEnabled(true);
            next.setEnabled(false);
        } else if (countPage == 0 && listFilteredRestaurants.toArray().length / 6 != countPage) {
            prev.setEnabled(false);
            next.setEnabled(true);
        } else {
            prev.setEnabled(false);
            next.setEnabled(false);
        }

    }

    public void searchList(String textInput) {
        countPage = 0;
        listFilteredRestaurants.clear();

        int count = 0;
        for (Restaurante restaurante: listRestaurants) {
            if (restaurante.nome.contains(textInput)) {
                count ++;
                listFilteredRestaurants.add(restaurante);
            }
        }

        if (count > 0) {
            updateListLabel();
        } else {
            restaurantsListLabel.removeAll();
            restaurantsListLabel.revalidate();
            restaurantsListLabel.repaint();

            JLabel dontHaveRestaurant = new JLabel("Não foi encontrado nenhum restaurante!");
            dontHaveRestaurant.setFont(new Font("Arial", Font.BOLD,20));
            dontHaveRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
            dontHaveRestaurant.setBounds(0,0,500,410);
            restaurantsListLabel.add(dontHaveRestaurant);

            verifyButtons();
        }


    }

    public void updateListLabel() {
        restaurantsListLabel.removeAll();
        restaurantsListLabel.revalidate();
        restaurantsListLabel.repaint();
        setRestaurants();
        verifyButtons();
    }
}
