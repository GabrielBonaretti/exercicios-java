package SpecialFigures;

import java.util.Scanner;

public class Parallelepiped {
    private double width;
    private double length;
    private double heigth;

    public double volume() {
        return width * length * heigth;
    }

    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite a largura do paralelepipedo: ");
                this.width = sc.nextDouble();

                System.out.print("Digite o comprimento do paralelepipedo: ");
                this.length = sc.nextDouble();

                System.out.print("Digite a altura do paralelepipedo: ");
                this.heigth = sc.nextDouble();

                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
                sc.next();
            }
        }
    }
}
