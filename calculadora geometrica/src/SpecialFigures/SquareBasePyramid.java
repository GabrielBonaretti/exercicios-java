package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;

// The SquareBasePyramid class implements the InterfaceSpecialFigures interface.
public class SquareBasePyramid implements InterfaceSpecialFigures {
    private double sideBase;
    private double height;

    // This method calculates and returns the volume of the squareBasePyramid.
    public double volume() {
        return (Math.pow(sideBase,2) * height)/3;
    }

    // This method is used to set the attributes or properties of the cone based on user input provided through the Scanner object.
    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o lado da base: ");
                this.sideBase = sc.nextDouble();

                System.out.print("Digite a altura: ");
                this.height = sc.nextDouble();


                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
