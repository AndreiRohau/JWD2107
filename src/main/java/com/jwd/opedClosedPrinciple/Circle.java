package com.jwd.opedClosedPrinciple;

public class Circle extends Shape implements DrawableGeoFigure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double countArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public String drawGeometricFigure() {
        ///
        return null;
    }
}
