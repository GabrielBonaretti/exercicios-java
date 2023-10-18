package FlatFigures;

import Interfaces.InterfaceFlatFigures;
import java.util.Scanner;

// The Triangle class implements the InterfaceFlatFigures interface.
public class Triangle implements InterfaceFlatFigures {
    private double side;

    // This method calculates and returns the perimeter of the Triangle.
    public double perimeter() {
        return side*3;
    }

    // This method calculates and returns the area of the Triangle.
    public double area() {
        return ((side*side) * Math.sqrt(3)) / 4;
    }

    // This method is used to set the attributes or properties of the Triangle based on user input provided through the Scanner object.
    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o lado do triângulo: ");
                this.side = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
