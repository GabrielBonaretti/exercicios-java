import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Armazena a sequência de Fibonacci com 21 elementos.
        long [] sequenciaFibonacci = new long[21];

        // Define os dois primeiros elementos da sequência.
        sequenciaFibonacci[0] = 0;
        sequenciaFibonacci[1] = 1;

        // Preenche o restante da sequência de Fibonacci a partir do terceiro elemento.
        for (int i = 2; i < sequenciaFibonacci.length; i++) {
            // Calcula o próximo número da sequência somando os dois anteriores.
            sequenciaFibonacci[i] = sequenciaFibonacci[i-2]+sequenciaFibonacci[i-1];
        }

        System.out.println(Arrays.toString(sequenciaFibonacci));
    }
}