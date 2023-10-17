package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;

public class SquareBasePyramid implements InterfaceSpecialFigures {
    private double sideBase;
    private double height;

    public double volume() {
        return (Math.pow(sideBase,2) * height)/3;
    }

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
