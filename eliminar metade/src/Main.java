import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        int mortes;
        ArrayList<String> listaPessoas = new ArrayList<>(List.of("gabriel", "eduarda", "julia", "laura", "henrique",
                "giovana R", "allana", "felipe", "lucas", "angelo",
                "diego c", "giovana m", "giovana f", "esther",
                "caio", "kadu", "nic", "diego nerd", "leo", "agatha", "clebinho"));

        ArrayList<String> listaMortos = new ArrayList<>();

        int totalPessoas = listaPessoas.size();

        if (listaPessoas.size() % 2 == 0) {
            mortes = listaPessoas.size() / 2;
        }else{
            mortes = listaPessoas.size() / 2 + 1;
        }
        for (int i = 0; i < mortes; i++) {
            int pessoaMortaIndex = gerador.nextInt(listaPessoas.size());
            String pessoaMorta = listaPessoas.get(pessoaMortaIndex);
            listaPessoas.remove(pessoaMorta);
            listaMortos.add(pessoaMorta);
        }

        System.out.println("Pessoas totais antes das mortes: " + totalPessoas);
        System.out.println("Mortes: " + mortes);
        System.out.println("Sobreviventes: "+listaPessoas);
        System.out.println("Mortos: " + listaMortos);
    }
}