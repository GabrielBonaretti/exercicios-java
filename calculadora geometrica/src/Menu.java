import FlatFigures.*;
import Interfaces.InterfaceFlatFigures;
import Interfaces.InterfaceSpecialFigures;
import SpecialFigures.*;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    // Initialize the menu choice as "0".
    public String menu = "0";
    public Scanner sc = new Scanner(System.in);

    // Method to print the menu options based on the current menu choice.
    public void printMenu() {
        switch (menu) {
            case "0":
                // Display the main menu for selecting geometric figures.
                System.out.println("\n-------------------------\n");
                System.out.println("Calculadora geométrica:");
                System.out.println("\n-------------------------\n");
                System.out.println("1 - Figuras planas");
                System.out.println("2 - Figuras especiais");
                System.out.println("3 - Sair");

                choiceMenuOption();
                break;
            case "01":
                // Menu options for flat figures.
                System.out.println("\n-------------------------\n");
                System.out.println("Figuras planas:");
                System.out.println("\n-------------------------\n");
                System.out.println("1 - Círculo");
                System.out.println("2 - Retângulo");
                System.out.println("3 - Hexagono regular");
                System.out.println("4 - Quadrado");
                System.out.println("5 - Triangulo");
                System.out.println("6 - Voltar");

                choiceMenuOption();
                break;
            case "011":
                // Create an instance of Circle and calculate/display its properties.
                Circle circle = new Circle();
                calculateDisplayFlat(circle);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "012":
                // Create an instance of Rectangle and calculate/display its properties.
                Rectangle rectangle = new Rectangle();
                calculateDisplayFlat(rectangle);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "013":
                // Create an instance of RegularHexagon and calculate/display its properties.
                RegularHexagon regularHexagon = new RegularHexagon();
                calculateDisplayFlat(regularHexagon);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "014":
                // Create an instance of Square and calculate/display its properties.
                Square square = new Square();
                calculateDisplayFlat(square);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "015":
                // Create an instance of Triangle and calculate/display its properties.
                Triangle triangle = new Triangle();
                calculateDisplayFlat(triangle);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "016", "027":
                // Return to the main menu.
                menu = "0";
                break;
            case "02":
                // Display the menu for selecting special figures.
                System.out.println("\n-------------------------\n");
                System.out.println("Figuras Especiais:");
                System.out.println("\n-------------------------\n");
                System.out.println("1 - Cone");
                System.out.println("2 - Cubo");
                System.out.println("3 - Cilindro");
                System.out.println("4 - Paralelepipedo");
                System.out.println("5 - Esfera");
                System.out.println("6 - Piramede");
                System.out.println("7 - Voltar");

                choiceMenuOption();
                break;
            case "021":
                // Calculate and display the volume of a Cone.
                Cone cone = new Cone();
                calculateDisplaySpecial(cone);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "022":
                // Calculate and display the volume of a Cube.
                Cube cube = new Cube();
                calculateDisplaySpecial(cube);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "023":
                // Calculate and display the volume of a Cylinder.
                Cylinder cylinder = new Cylinder();
                calculateDisplaySpecial(cylinder);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "024":
                // Calculate and display the volume of a Parallelepiped.
                Parallelepiped parallelepiped = new Parallelepiped();
                calculateDisplaySpecial(parallelepiped);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "025":
                // Calculate and display the volume of a Sphere.
                Sphere sphere = new Sphere();
                calculateDisplaySpecial(sphere);
                menu = menu.substring(0, menu.length() - 1);
                break;
            case "026":
                // Calculate and display the volume of a Pyramid.
                SquareBasePyramid pyramid = new SquareBasePyramid();
                calculateDisplaySpecial(pyramid);
                menu = menu.substring(0, menu.length() - 1);
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                menu = menu.substring(0, menu.length() - 1);
                break;
        }
    }

    // Method to handle user menu choices.
    public void choiceMenuOption() {
        while (true) {
            try {
                System.out.print("Escolha a opção no menu: ");
                int choice = sc.nextInt();
                menu = menu + choice; // Update the menu choice.
                break;
            } catch (Exception e) {
                System.out.println("Apenas números");
                sc.next();
            }
        }
    }

    // Method to check if the program should exit.
    public String isFinished() {
        if (Objects.equals(menu, "03")) {
            // If the user chooses option 3, exit the program.
            return "N";
        }
        return "S"; // Continue the program.
    }

    // Method to calculate and display properties of flat figures.
    public void calculateDisplayFlat(InterfaceFlatFigures flatFigure) {
        flatFigure.setAtributes(sc);
        double flatFigureArea = flatFigure.area();
        double flatFigurePerimeter =flatFigure.perimeter();
        System.out.printf("Área: %.2f. Perimetro: %.2f \n", flatFigureArea, flatFigurePerimeter);
        sc.next();
    }

    // Method to calculate and display properties of special figures.
    public void calculateDisplaySpecial(InterfaceSpecialFigures specialFigure) {
        specialFigure.setAtributes(sc);
        double specialFigureVolume = specialFigure.volume();
        System.out.printf("Volume: %.2f \n", specialFigureVolume);
        sc.next();
    }
}
