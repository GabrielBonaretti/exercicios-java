package SpecialFigures;

import java.util.Scanner;

public class Sphere {
    private double radius;
    private static double pi = Math.PI;
    public Sphere(double radius){
        this.radius = radius;
    }

    public double volume() {
        return ((double) 4/3) * pi * Math.pow(radius, 3);
    }

    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.println("Digite o raio da esfera: ");
                this.radius = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
            }
        }
    }
}
