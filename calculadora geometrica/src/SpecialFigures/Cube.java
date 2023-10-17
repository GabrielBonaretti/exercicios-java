package SpecialFigures;

import Interfaces.InterfaceSpecialFigures;
import java.util.Scanner;

public class Cube implements InterfaceSpecialFigures {
    private double side;

    public double volume() {
        return Math.pow(side, 3);
    }

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
