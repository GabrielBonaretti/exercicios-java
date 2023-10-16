import FlatFigures.Circle;
import FlatFigures.Rectangle;

import java.util.Scanner;

public class Menu {
    public String menu = "0";
    public Scanner sc = new Scanner(System.in);
    public void printMenu() {
        switch (menu) {
            case "0":
                System.out.println("Calculadora geométrica:");
                System.out.println("-------------------------\n");
                System.out.println("1 - Figuras planas");
                System.out.println("2 - Figuras especiais");

                choiceMenuOption();
                break;
            case "01":
                System.out.println("Figuras planas:");
                System.out.println("-------------------------\n");
                System.out.println("1 - Círculo");
                System.out.println("2 - Retângulo");
                System.out.println("3 - Hexagono regular");
                System.out.println("4 - Quadrado");
                System.out.println("5 - Triangulo");
                System.out.println("6 - Voltar");

                choiceMenuOption();
                break;
            case "011":
                Circle circle = new Circle();
                circle.setAtributes(sc);
                double circleArea = circle.area();
                double circlePerimeter =circle.perimeter();

                System.out.println("CÍRCULO");
                System.out.printf("Área: %.2f. Perimetro: %.2f \n", circleArea, circlePerimeter);
                break;
            case "012":
                Rectangle rectangle = new Rectangle();
                rectangle.setAtributes(sc);
                double rectangleArea = rectangle.area();
                double rectanglePerimeter =rectangle.perimeter();

                System.out.println("RETÂNGULO");
                System.out.printf("Área: %.2f. Perimetro: %.2f \n", rectangleArea, rectanglePerimeter);
                break;
            case "016":
                menu = "0";
                break;
            case "02":
                System.out.println("Figuras Especiais:");
                System.out.println("-------------------------\n");
                System.out.println("1 - Esfera");
                System.out.println("2 - Cubo");
                System.out.println("3 - Cilindro");
                System.out.println("4 - Paralelepipedo");
                System.out.println("5 - Cone");
                System.out.println("6 - Piramede");
                break;
            default:
                System.out.println("opcao errada burro");
                menu = menu.substring(0, menu.length() - 1);
                break;
        }
    }

    public void choiceMenuOption() {
        System.out.println("Escolha a opção no menu: ");
        int choice = sc.nextInt();
        menu = menu + choice;
    }


}
