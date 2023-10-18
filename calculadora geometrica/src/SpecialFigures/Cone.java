package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;


// The Cone class implements the InterfaceSpecialFigures interface.
public class Cone implements InterfaceSpecialFigures {
    private double radiusBase;
    private double height;
    private static double pi = Math.PI;


    // This method calculates and returns the volume of the cone.
    public double volume() {
        double areaBase = pi * (radiusBase * radiusBase);
        return (areaBase * height) / 3;
    }

    // This method is used to set the attributes or properties of the cone based on user input provided through the Scanner object.
    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o raio da base: ");
                this.radiusBase = sc.nextDouble();

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
