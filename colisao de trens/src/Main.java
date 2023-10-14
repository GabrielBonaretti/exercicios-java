import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueGame = "S";

        while (continueGame.equals("S")) {
            int startingPositionA = verifyPosition(sc, "A");
            int startingPositionB = verifyPosition(sc, "B");
            int velocityA = verifyVelocity(sc, "A");
            int velocityB = verifyVelocity(sc, "B");

            double time = (double) (startingPositionA - startingPositionB) / (velocityB - velocityA);

            double a = startingPositionA + velocityA * time;
            double b = startingPositionB + velocityB * time;

            String timeFormat = transformHoursTime(time);
            System.out.printf("A colisão de trens acontecerá no KM %.0f e ocorrerá após %.0f segundos, as %s \n", a, time*3600, timeFormat);

            continueGame = continueInput(sc);
        }
    }

    public static String transformHoursTime(double timeHours) {
        double minutesTimeConverted = Math.abs((timeHours - (int)timeHours) * 60);
        double secondsTimeConverted = Math.abs((minutesTimeConverted - (int)minutesTimeConverted) * 60);

        String hoursString = String.valueOf((int)timeHours + 17);
        String minutesString = String.valueOf((int)minutesTimeConverted);
        String secondsString = String.valueOf((int)secondsTimeConverted);

        String hoursStringFormat = String.format("%2s", hoursString).replace(' ', '0');
        String minutesStringFormat = String.format("%2s", minutesString).replace(' ', '0');
        String secondsStringFormat = String.format("%2s", secondsString).replace(' ', '0');

        return String.format("%s:%s:%s", hoursStringFormat, minutesStringFormat, secondsStringFormat);
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

    public static int verifyPosition(Scanner sc, String train) {
        while (true) {
            try {
                System.out.printf("Digite a posição inicial do trem %s: ", train);
                int position = sc.nextInt();

                if (position >= 0 && position < 10000) {
                    return position;
                } else {
                    System.out.println("O número deve ser maior ou igual a zero e menor que 10000.");
                    sc.nextLine();
                }
            } catch (Exception e) {
                System.out.println("Você digitou um caractere inválido. Por favor, digite novamente.");
                sc.nextLine();
            }
        }
    }

    public static int verifyVelocity(Scanner sc, String train) {
        while (true) {
            try {
                System.out.printf("Digite a velocidade do trem %s: ", train);
                int velocity = sc.nextInt();

                if (Objects.equals(train, "A") && velocity < 0) {
                    System.out.println("A velocidade do trem A sempre será positiva. Por favor, digite novamente.");
                    sc.nextLine();
                } else if (Objects.equals(train, "B") && velocity > 0) {
                    System.out.println("A velocidade do trem A sempre será negativa. Por favor, digite novamente.");
                    sc.nextLine();
                } else {
                    return velocity;
                }
            } catch (Exception e) {
                System.out.println("Você digitou um caractere inválido. Por favor, digite novamente.");
                sc.nextLine();
            }
        }
    }
}