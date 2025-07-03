package com.example.demo;

public class Circle extends Figure {
    private double r;

    public Circle(double r, Point center) {
        super(center, Color.BLACK);
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(r, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    public void draw(Color color) {
        System.out.println("Circle: cords " + "(" + point.getX() + ", " + point.getY() + ")" +
                            ", radius: " + r + ", color: " + color);
    }
}