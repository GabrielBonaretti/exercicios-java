import FlatFigures.*;
import SpecialFigures.*;

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
            case "013":
                RegularHexagon regularHexagon = new RegularHexagon();
                regularHexagon.setAtributes(sc);
                double regularHexagonArea = regularHexagon.area();
                double regularHexagonPerimeter =regularHexagon.perimeter();

                System.out.println("HEXÁGONO REGULAR");
                System.out.printf("Área: %.2f. Perimetro: %.2f \n", regularHexagonArea, regularHexagonPerimeter);
                break;
            case "014":
                Square square = new Square();
                square.setAtributes(sc);
                double squareArea = square.area();
                double squarePerimeter =square.perimeter();

                System.out.println("QUADRADO");
                System.out.printf("Área: %.2f. Perimetro: %.2f \n", squareArea, squarePerimeter);
                break;
            case "015":
                Triangle triangle = new Triangle();
                triangle.setAtributes(sc);
                double triangleArea = triangle.area();
                double trianglePerimeter =triangle.perimeter();

                System.out.println("TRIÂNGULO");
                System.out.printf("Área: %.2f. Perimetro: %.2f \n", triangleArea, trianglePerimeter);
                break;
            case "016", "027":
                menu = "0";
                break;
            case "02":
                System.out.println("Figuras Especiais:");
                System.out.println("-------------------------\n");
                System.out.println("1 - Cone");
                System.out.println("2 - Cubo");
                System.out.println("3 - Cilindro");
                System.out.println("4 - Paralelepipedo");
                System.out.println("5 - Esfera");
                System.out.println("6 - Piramede");
                System.out.println("7 - Voltar");
                break;
            case "021":
                Cone cone = new Cone();
                cone.setAtributes(sc);
                double coneVolume = cone.volume();

                System.out.println("CONE");
                System.out.printf("Volume: %.2f \n", coneVolume);
                break;
            case "022":
                Cube cube = new Cube();
                cube.setAtributes(sc);
                double cubeVolume = cube.volume();

                System.out.println("CUBO");
                System.out.printf("Volume: %.2f \n", cubeVolume);
                break;
            case "023":
                Cylinder cylinder = new Cylinder();
                cylinder.setAtributes(sc);
                double cylinderVolume = cylinder.volume();

                System.out.println("CILINDRO");
                System.out.printf("Volume: %.2f \n", cylinderVolume);
                break;
            case "024":
                Parallelepiped parallelepiped = new Parallelepiped();
                parallelepiped.setAtributes(sc);
                double parallelepipedVolume = parallelepiped.volume();

                System.out.println("PARALELEPIPEDO");
                System.out.printf("Volume: %.2f \n", parallelepipedVolume);
                break;
            case "025":
                Sphere sphere = new Sphere();
                sphere.setAtributes(sc);
                double sphereVolume = sphere.volume();

                System.out.println("ESFERA");
                System.out.printf("Volume: %.2f \n", sphereVolume);
                break;
            case "026":
                SquareBasePyramid pyramid = new SquareBasePyramid();
                pyramid.setAtributes(sc);
                double pyramidVolume = pyramid.volume();

                System.out.println("PIRÂMIDE");
                System.out.printf("Volume: %.2f \n", pyramidVolume);
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
