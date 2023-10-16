import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueGame = "S";

        while (continueGame.equals("S")) {
            continueGame = continueInput(sc);
        }
    }

    public static String continueInput(Scanner sc) {
        sc.nextLine();
        while (true) {
            System.out.print("Você deseja continuar? (S/N): ");
            String testContinue = sc.nextLine().toUpperCase();
            if (testContinue.equals("S") || testContinue.equals("N")) {
                return testContinue;
            }
        }
    }

    public static int menu(Scanner sc, int typeMenu) {
        int selection;
        switch (typeMenu) {
            case 1:
                System.out.println("Calculadora geométrica:");
                System.out.println("-------------------------\n");
                System.out.println("1 - Figuras planas");
                System.out.println("2 - Figuras especiais");
                System.out.println("3 - Fechar");

                selection = sc.nextInt();
                return selection;
            case 2:
                System.out.println("Figuras planas:");
                System.out.println("-------------------------\n");
                System.out.println("1 - Circulo");
                System.out.println("2 - Retangulo");
                System.out.println("3 - Hexagono regular");
                System.out.println("4 - Quadrado");
                System.out.println("5 - Triangulo");
                System.out.println("6 - Voltar");

                selection = sc.nextInt();
                return selection;
            case 3:
                System.out.println("Figuras Especiais:");
                System.out.println("-------------------------\n");
                System.out.println("1 - Esfera");
                System.out.println("2 - Cubo");
                System.out.println("3 - Cilindro");
                System.out.println("4 - Paralelepipedo");
                System.out.println("5 - Cone");
                System.out.println("6 - Piramede");
                selection = sc.nextInt();
                return selection;
        }

        return 0;
    }
}