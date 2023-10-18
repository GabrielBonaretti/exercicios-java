package FlatFigures;

import Interfaces.InterfaceFlatFigures;
import java.util.Scanner;

// The Rectangle implements the InterfaceFlatFigures interface.
public class Rectangle implements InterfaceFlatFigures {
    private double width;
    private double length;

    // This method calculates and returns the perimeter of the Rectangle.
    public double perimeter() {
        return width * 2 + length * 2;
    }

    // This method calculates and returns the area of the Rectangle.
    public double area() {
        return width*length;
    }

    // This method is used to set the attributes or properties of the Rectangle based on user input provided through the Scanner object.
    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite a largura do retangulo: ");
                this.width = sc.nextDouble();

                System.out.print("Digite o comprimento do retangulo: ");
                this.length = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
