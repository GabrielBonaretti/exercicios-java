public class Main {
    public static void main(String[] args) {
        // Initialize the menu system and set the initial game continuation flag to "S".
        String continueGame = "S";
        Menu menu = new Menu();

        // Continue the game until the user chooses to exit.
        while (continueGame.equals("S")) {
            // Display the main menu to the user.
            menu.printMenu();

            // Check if the user wants to continue or exit the game.
            continueGame = menu.isFinished();
        }
    }
}