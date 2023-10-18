package FlatFigures;

import Interfaces.InterfaceFlatFigures;
import java.util.Scanner;

// The RegularHexagon class implements the InterfaceFlatFigures interface.
public class RegularHexagon implements InterfaceFlatFigures {
    private double side;

    // This method calculates and returns the perimeter of the RegularHexagon.
    public double perimeter() {
        return side*6;
    }

    // This method calculates and returns the area of the RegularHexagon.
    public double area() {
        return (6 * (side*side) * Math.sqrt(3)) / 4;
    }

    // This method is used to set the attributes or properties of the RegularHexagon based on user input provided through the Scanner object.
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
