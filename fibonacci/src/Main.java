import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long [] sequenciaFibonacci = new long[21];
        sequenciaFibonacci[0] = 0;
        sequenciaFibonacci[1] = 1;
        for (int i = 2; i < sequenciaFibonacci.length; i++) {
            sequenciaFibonacci[i] = sequenciaFibonacci[i-2]+sequenciaFibonacci[i-1];
        }

        System.out.println(Arrays.toString(sequenciaFibonacci));
    }
}