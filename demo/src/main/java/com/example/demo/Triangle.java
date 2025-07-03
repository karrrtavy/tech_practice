package com.example.demo;

public class Triangle extends Figure {
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        super(point1, Color.BLACK);
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public double perimeter() {
        return FigureUtil.lenP2P(point, point2) + 
               FigureUtil.lenP2P(point2, point3) + 
               FigureUtil.lenP2P(point3, point);
    }

    @Override
    public double area() {
        double a = FigureUtil.lenP2P(point, point2);
        double b = FigureUtil.lenP2P(point2, point3);
        double c = FigureUtil.lenP2P(point3, point);
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Drawing triangles: high (%d, %d), (%d, %d), (%d, %d), color %s%n",
                         point.getX(), point.getY(),
                         point2.getX(), point2.getY(),
                         point3.getX(), point3.getY(), color);
    }
}