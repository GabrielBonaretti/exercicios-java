package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;

// The Parallelepiped class implements the InterfaceSpecialFigures interface.
public class Parallelepiped implements InterfaceSpecialFigures {
    private double width;
    private double length;
    private double heigth;

    // This method calculates and returns the volume of the parallelepiped.
    public double volume() {
        return width * length * heigth;
    }

    // This method is used to set the attributes or properties of the cone based on user input provided through the Scanner object.
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
