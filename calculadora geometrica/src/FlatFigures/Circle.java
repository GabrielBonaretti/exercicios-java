package FlatFigures;

import Interfaces.InterfaceFlatFigures;
import java.util.Scanner;

public class Circle implements InterfaceFlatFigures {
    private double radius;
    private static double pi = Math.PI;

    public double perimeter() {
        return 2 * pi * radius;
    }

    public double area() {
        return pi * (radius * radius);
    }

    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o raio do circulo: ");
                this.radius = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
