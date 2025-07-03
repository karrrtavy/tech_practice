package com.example.demo;

public class FigureUtil {

    private FigureUtil() {}

    public static double area(Figure figure) { return figure.area(); }

    public static double perimeter(Figure figure) { return figure.perimeter(); }

    public static void draw(Figure figure) { figure.draw();}

    public static void draw(Figure figure, Color color) { figure.draw(color); }

    public static double lenP2P(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) + Math.pow(point2.getY() - point1.getY(), 2));
    }
}