package FlatFigures;

import Interfaces.InterfaceFlatFigures;
import java.util.Scanner;

// The Square class implements the InterfaceFlatFigures interface.
public class Square implements InterfaceFlatFigures {
    private double side;

    // This method calculates and returns the perimeter of the Square.
    public double perimeter() {
        return side*4;
    }

    // This method calculates and returns the area of the Square.
    public double area() {
        return side*side;
    }

    // This method is used to set the attributes or properties of the Square based on user input provided through the Scanner object.
    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o lado do quadrado: ");
                this.side = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
