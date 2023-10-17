package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;

public class Sphere implements InterfaceSpecialFigures {
    private double radius;
    private static double pi = Math.PI;

    public double volume() {
        return ((double) 4/3) * pi * Math.pow(radius, 3);
    }

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
