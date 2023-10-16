package FlatFigures;

import java.util.Scanner;

public class Square {
    private double side;

    public double perimeter() {
        return side*4;
    }

    public double area() {
        return side*side;
    }

    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o lado do quadrado: ");
                this.side = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
            }
        }
    }
}
