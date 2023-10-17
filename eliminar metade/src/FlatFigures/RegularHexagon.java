package FlatFigures;

import java.util.Scanner;

public class RegularHexagon {
    private double side;

    public double perimeter() {
        return side*6;
    }

    public double area() {
        return (6 * (side*side) * Math.sqrt(3)) / 4;
    }

    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite um lado do hexagono: ");
                this.side = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
