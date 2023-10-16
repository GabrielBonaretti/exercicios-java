package SpecialFigures;

public class Cone {
    private double radiusBase;
    private double height;
    private static double pi = Math.PI;

    public Cone(double radiusBase, double height) {
        this.radiusBase = radiusBase;
        this.height = height;
    }

    public double volume() {
        double areaBase = pi * (radiusBase * radiusBase);
        return (areaBase * height) / 3;
    }
}
