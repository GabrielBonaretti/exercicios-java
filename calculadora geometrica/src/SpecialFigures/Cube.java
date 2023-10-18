package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;

// The Cube class implements the InterfaceSpecialFigures interface.
public class Cube implements InterfaceSpecialFigures {
    private double side;

    // This method calculates and returns the volume of the cube.
    public double volume() {
        return Math.pow(side, 3);
    }

    // This method is used to set the attributes or properties of the cone based on user input provided through the Scanner object.
    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o lado do cubo: ");
                this.side = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
