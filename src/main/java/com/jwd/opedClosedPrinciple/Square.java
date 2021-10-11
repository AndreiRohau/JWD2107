package com.jwd.opedClosedPrinciple;

public class Square extends Shape implements DrawableGeoFigure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double countArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }

    @Override
    public String drawGeometricFigure() {
        ///....
        return null;
    }
}
