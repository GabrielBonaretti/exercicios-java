package Interfaces;

import java.util.Scanner;

// This interface represents a contract for flat geometric figures.
public interface InterfaceFlatFigures {
    // This method calculates and returns the perimeter of the geometric figure.
    public double perimeter();

    // This method calculates and returns the area of the geometric figure.
    public double area();

    // This method is used to set the attributes or properties of the geometric figure.
    public void setAtributes(Scanner sc);
}
