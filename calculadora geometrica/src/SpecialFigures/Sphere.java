package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;

// The Sphere class implements the InterfaceSpecialFigures interface.
public class Sphere implements InterfaceSpecialFigures {
    private double radius;
    private static double pi = Math.PI;

    // This method calculates and returns the volume of the sphere.
    public double volume() {
        return ((double) 4/3) * pi * Math.pow(radius, 3);
    }

    // This method is used to set the attributes or properties of the cone based on user input provided through the Scanner object.
    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite o raio da esfera: ");
                this.radius = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
