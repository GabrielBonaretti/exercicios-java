package src.Database;

import java.sql.*;

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
            System.err.println("Erro salvando o produto");
            System.exit(-42);
        }
    }
}
