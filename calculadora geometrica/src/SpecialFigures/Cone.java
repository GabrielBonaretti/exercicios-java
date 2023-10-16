package SpecialFigures;

import java.util.Scanner;

public class Cone {
    private double radiusBase;
    private double height;
    private static double pi = Math.PI;


    public double volume() {
        double areaBase = pi * (radiusBase * radiusBase);
        return (areaBase * height) / 3;
    }

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
            }
        }
    }
}
