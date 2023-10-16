package SpecialFigures;

public class SquareBasePyramid {
    private double sideBase;
    private double height;

    public SquareBasePyramid(double sideBase, double height) {
        this.sideBase = sideBase;
        this.height = height;
    }

    public double volume() {
        return (Math.pow(sideBase,2) * height)/3;
    }
}
