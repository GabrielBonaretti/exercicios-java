package FlatFigures;

import Interfaces.InterfaceFlatFigures;
import java.util.Scanner;

// The Circle class implements the InterfaceFlatFigures interface.
public class Circle implements InterfaceFlatFigures {
    private double radius;
    private static double pi = Math.PI;

    // This method calculates and returns the perimeter (circumference) of the circle.
    public double perimeter() {
        return 2 * pi * radius;
    }

    // This method calculates and returns the area of the circle.
    public double area() {
        return pi * (radius * radius);
    }

    // This method is used to set the attributes or properties of the circle based on user input provided through the Scanner object.
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
