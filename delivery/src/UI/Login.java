package src.UI;

//rgb(9,8,9)
//rgb(244,0,0)
//rgb(244,78,63)
//rgb(244,121,107)
//rgb(244,153,141)
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Login extends JPanel {
    public Login() {
        this.setBounds(0,0, 1000, 800);
        this.setBackground(new Color(240,240,240));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(null);

        JLabel containerForm = new JLabel();
        containerForm.setBounds(300, 150, 400, 450);
        containerForm.setBackground(new Color(170,170,170));
        containerForm.setOpaque(true);

        JLabel titulo = new JLabel();
        titulo.setText("Login");
        titulo.setFont(new Font("Arial", Font.BOLD,20));
        titulo.setBounds(172, 50, 55, 40);

        JLabel inputNome = new Input("Nome", 75, 150, 250);
        JLabel inputSenha = new InputSenha("Senha", 75, 220, 250);

        BotaoLoginCadastrar botaoCadastrar = new BotaoLoginCadastrar("Não tem uma conta? Cadastre-se!", 150, 290);

        JButton Avancar = new JButton();
        Avancar.setText("Entrar");
        Avancar.setFont(new Font("Arial", Font.BOLD,20));
        Avancar.setFocusable(false);
        Avancar.setBounds(150, 350, 100, 40);

        containerForm.add(titulo);
        containerForm.add(inputNome);
        containerForm.add(inputSenha);
        containerForm.add(botaoCadastrar);
        containerForm.add(Avancar);

        this.add(containerForm);
    }
}
