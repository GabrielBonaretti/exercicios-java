package src.Database;

import src.Entities.Endereco;
import src.Entities.Lanche;
import src.Entities.Restaurante;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    public Connection conectar() {
        String CLASSE_DRIVER = "com.mysql.cj.jdbc.Driver";
        String USUARIO = "root";
        String SENHA = "";
        String URL_SERVIDOR = "jdbc:mysql://localhost:3306/delivery?useSSL=false";

        try {
            Class.forName(CLASSE_DRIVER);
            return DriverManager.getConnection(URL_SERVIDOR, USUARIO, SENHA);
        } catch (Exception e) {
            if (e instanceof ClassNotFoundException) {
                e.printStackTrace();
                System.err.println("Verifique o driver de conexão");
            } else {
                System.err.println("Verifique se o servidor está ativo");
            }
            System.exit(-42);
            return null;
        }
    }

    public void desconectar(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException e) {
                System.err.println("Não foi possível fechar a conexão.");
            }
        }
    }

    public void createUser(String name, String cpf, int positionX, int positionY, String password) {
        String hexPassword = HashPassword.hexPassword(password);

        String INSERIR = "INSERT INTO users (name, cpf, positionX, positionY, password) VALUES (?, ?, ?, ?, ?)";


        try {
            Connection conn = conectar();
            PreparedStatement salvar = conn.prepareStatement(INSERIR);

            salvar.setString(1, name);
            salvar.setString(2, cpf);
            salvar.setInt(3, positionX);
            salvar.setInt(4, positionY);
            salvar.setString(5, hexPassword);

            salvar.executeUpdate();
            salvar.close();
            desconectar(conn);

            System.out.println("O usuario " + name + " foi inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro salvando o produto");
            System.exit(-42);
        }
    }

    public void createRestaurant(String name, String cnpj, int positionX, int positionY, String password) {
        String hexPassword = HashPassword.hexPassword(password);

        String INSERIR = "INSERT INTO restaurants (name, cnpj, positionX, positionY, password) VALUES (?, ?, ?, ?, ?)";


        try {
            Connection conn = conectar();
            PreparedStatement salvar = conn.prepareStatement(INSERIR);

            salvar.setString(1, name);
            salvar.setString(2, cnpj);
            salvar.setInt(3, positionX);
            salvar.setInt(4, positionY);
            salvar.setString(5, hexPassword);

            salvar.executeUpdate();
            salvar.close();
            desconectar(conn);

            System.out.println("O usuario " + name + " foi inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-42);
        }
    }

    public int verifyAcountUser(String name, String password) {
        String hexPassword = HashPassword.hexPassword(password);

        String VERIFY = "SELECT * FROM users WHERE name=? AND password=?";

        try {
            Connection conn = conectar();
            PreparedStatement user = conn.prepareStatement(VERIFY);

            user.setString(1, name);
            user.setString(2, hexPassword);

            ResultSet resultado = user.executeQuery();

            if (resultado.isBeforeFirst() && resultado.next()) {
                int idUser = resultado.getInt(1);
                user.close();
                desconectar(conn);
                return idUser;
            } else {
                user.close();
                desconectar(conn);
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-42);
        }
        return 0;
    }

    public int verifyAcountRestaurant(String name, String password) {
        String hexPassword = HashPassword.hexPassword(password);

        String VERIFY = "SELECT * FROM restaurants WHERE name=? AND password=?";

        try {
            Connection conn = conectar();
            PreparedStatement user = conn.prepareStatement(VERIFY);

            user.setString(1, name);
            user.setString(2, hexPassword);

            ResultSet resultado = user.executeQuery();

            if (resultado.isBeforeFirst() && resultado.next()) {
                int idUser = resultado.getInt(1);
                user.close();
                desconectar(conn);
                return idUser;
            } else {
                user.close();
                desconectar(conn);
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-42);
        }
        return 0;
    }

    public ArrayList<Restaurante> getAllRestaurants() {
        String getAllRestaurants = "SELECT * FROM restaurants";
        ArrayList<Restaurante> listaRestaurants = new ArrayList<>();
        try {
            Connection conn = conectar();
            PreparedStatement restaurant = conn.prepareStatement(getAllRestaurants);

            ResultSet resultado = restaurant.executeQuery();

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    Endereco endereco = new Endereco(resultado.getInt(4),resultado.getInt(5));
                    Restaurante restaurante = new Restaurante(resultado.getString(2), endereco);
                    restaurante.setId(resultado.getInt(1));
                    listaRestaurants.add(restaurante);
                }
            } else {
                System.out.println("Não existem restaurantes cadastrados.");
            }

            restaurant.close();
            desconectar(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-42);
        }

        return listaRestaurants;
    }

    public Restaurante getRestaurant(int id) {
        String getRestaurant = "SELECT * FROM restaurants WHERE id=?";
        Restaurante restaurante = null;
        try {
            Connection conn = conectar();
            PreparedStatement restaurant = conn.prepareStatement(getRestaurant);

            restaurant.setInt(1, id);


            ResultSet resultado = restaurant.executeQuery();

            if (resultado.isBeforeFirst() && resultado.next()) {
                Endereco endereco = new Endereco(resultado.getInt(4),resultado.getInt(5));
                restaurante = new Restaurante(resultado.getString(2), endereco);
            } else {
                System.out.println("Não existe esse restaurante.");
            }

            restaurant.close();
            desconectar(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-42);
        }

        return restaurante;
    }

    public ArrayList<Lanche> getAllFoods(int id) {
        String getAllFoods = "SELECT * FROM foods WHERE idRestaurant=?";
        ArrayList<Lanche> listFoods = new ArrayList<>();
        try {
            Connection conn = conectar();
            PreparedStatement food = conn.prepareStatement(getAllFoods);

            food.setInt(1, id);

            ResultSet resultado = food.executeQuery();

            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    Lanche newFood = new Lanche(resultado.getString(3), resultado.getDouble(4));
                    newFood.setId(resultado.getInt(1));
                    listFoods.add(newFood);
                }
            } else {
                System.out.println("Não existem foods na loja.");
            }

            food.close();
            desconectar(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-42);
        }

        return listFoods;
    }

    public void addFood(int idRestaurant, String name, Double preco) {
        String ADDFOOD = "INSERT INTO foods (idRestaurant, name, preco) VALUES (?, ?, ?)";

        try {
            Connection conn = conectar();
            PreparedStatement insertFood = conn.prepareStatement(ADDFOOD);

            insertFood.setInt(1, idRestaurant);
            insertFood.setString(2, name);
            insertFood.setDouble(3, preco);

            insertFood.executeUpdate();
            insertFood.close();
            desconectar(conn);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-42);
        }
    }

    public void deleteFood(int idFood) {
        String SEARCH_FOR_ID = "SELECT * FROM foods WHERE id=?";
        String DELETE_FOOD = "DELETE FROM foods WHERE id=?";

        try {
            Connection conn = conectar();
            PreparedStatement searchFood = conn.prepareStatement(SEARCH_FOR_ID);

            searchFood.setInt(1, idFood);


            ResultSet resultado = searchFood.executeQuery();

            if (resultado.isBeforeFirst()) {
                PreparedStatement deleteFood = conn.prepareStatement(DELETE_FOOD);

                deleteFood.setInt(1, idFood);

                deleteFood.executeUpdate();
            } else {
                System.out.println("Não existe produto com o ID informado.");
            }

            searchFood.close();
            desconectar(conn);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-42);
        }
    }
}
