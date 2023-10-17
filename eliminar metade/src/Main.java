import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Inicialização de um gerador de números aleatórios.
        Random gerador = new Random();

        // Variável para armazenar o número de mortes.
        int mortes;

        // Lista de pessoas iniciais.
        ArrayList<String> listaPessoas = new ArrayList<>(List.of("gabriel", "eduarda", "julia", "laura", "henrique",
                "giovana R", "allana", "felipe", "lucas", "angelo",
                "diego c", "giovana m", "giovana f", "esther",
                "caio", "kadu", "nic", "diego nerd", "leo", "agatha", "clebinho"));

        // Lista para armazenar as pessoas que foram mortas.
        ArrayList<String> listaMortos = new ArrayList<>();

        // Número total de pessoas.
        int totalPessoas = listaPessoas.size();

        // Cálculo do número de mortes: metade das pessoas, arredondando para cima, se for ímpar.
        if (listaPessoas.size() % 2 == 0) {
            mortes = listaPessoas.size() / 2;
        }else{
            mortes = listaPessoas.size() / 2 + 1;
        }

        // For para realizar as mortes.
        for (int i = 0; i < mortes; i++) {
            // Geração de um índice aleatório para escolher uma pessoa a ser morta.
            int pessoaMortaIndex = gerador.nextInt(listaPessoas.size());
            String pessoaMorta = listaPessoas.get(pessoaMortaIndex);

            // Remoção da pessoa morta da lista de pessoas e adição à lista de mortos.
            listaPessoas.remove(pessoaMorta);
            listaMortos.add(pessoaMorta);
        }

        System.out.println("Pessoas totais antes das mortes: " + totalPessoas);
        System.out.println("Mortes: " + mortes);
        System.out.println("Sobreviventes: "+listaPessoas);
        System.out.println("Mortos: " + listaMortos);
    }
}