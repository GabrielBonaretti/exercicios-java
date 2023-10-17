import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int returnInput(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite um numero inteiro: ");
                return sc.nextInt();
            }catch (Exception e) {
                sc.nextLine();
            }
        }
    }

    public static ArrayList<Integer> verifyPrimes(int numberInput) {
        ArrayList<Integer> listPrimeNumbers = new ArrayList<Integer>();
        int count;

        for (int i = 1; i <= numberInput; i++) {
            count = 0;
            for (int j = 1; j <= i; j++ ) {
                if (i % j == 0) {
                    count += 1;
                }
            }

            if (count <= 2) {
                listPrimeNumbers.add(i);
            }
        }

        return listPrimeNumbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberInput = returnInput(sc);
        ArrayList<Integer> listPrimeNumbers = verifyPrimes(numberInput);
        System.out.println(listPrimeNumbers);
    }
}