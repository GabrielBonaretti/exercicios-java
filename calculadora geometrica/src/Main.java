import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueGame = "S";
        Menu menu = new Menu();
        while (continueGame.equals("S")) {
            menu.printMenu();

            continueGame = menu.isFinished();
        }
    }
}