package FlatFigures;

import java.util.Scanner;

public class Triangle {
    private double side;

    public double perimeter() {
        return side*3;
    }

    public double area() {
        return ((side*side) * Math.sqrt(3)) / 4;
    }

    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.println("Digite o lado do triângulo: ");
                this.side = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
            }
        }
    }
}
