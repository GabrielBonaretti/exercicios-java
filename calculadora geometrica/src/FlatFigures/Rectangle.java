package FlatFigures;

import java.util.Scanner;

public class Rectangle {
    private double width;
    private double length;

    public double perimeter() {
        return width * 2 + length * 2;
    }

    public double area() {
        return width*length;
    }

    public void setAtributes(Scanner sc) {
        while(true) {
            try {
                System.out.print("Digite a largura do retangulo: ");
                this.width = sc.nextDouble();

                System.out.print("Digite o comprimento do retangulo: ");
                this.length = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Digite um valor válido!");
            }
        }
    }
}
