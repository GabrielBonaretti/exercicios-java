package SpecialFigures;

public class Parallelepiped {
    private double width;
    private double length;
    private double heigth;

    public Parallelepiped(double width, double length, double heigth) {
        this.width = width;
        this.length = length;
        this.heigth = heigth;
    }

    public double volume() {
        return width * length * heigth;
    }
}
