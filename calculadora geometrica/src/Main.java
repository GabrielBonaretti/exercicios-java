import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueGame = "S";
        Menu menu = new Menu();
        while (continueGame.equals("S")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            menu.printMenu();
//            continueGame = continueInput(sc);
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

}