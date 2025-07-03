package com.example.demo;

public class Square extends Rectangle {

    public Square(double width, Point point) {
        super(width, width, point);
    }

    @Override
    public void draw(Color color) {
        System.out.println("Square: cords " + "(" + point.getX() + ", " + point.getY() + ")" +
                            ", width: " + width + ", color: " + color);
    }
}