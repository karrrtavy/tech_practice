package com.example.demo;

public class PaintExample {
    public static void main(String[] args) {
        Circle circle = new Circle(5, new Point(0, 0));
        Triangle triangle = new Triangle(
            new Point(0, 0), 
            new Point(4, 0), 
            new Point(0, 3)
        );
        Rectangle rectangle = new Rectangle(5, 10, new Point(0, 0));
        Square square = new Square(4, new Point(0, 0));

        System.out.println("Circle area: " + FigureUtil.area(circle));
        System.out.println("Circle length: " + FigureUtil.perimeter(circle));
        FigureUtil.draw(circle);

        System.out.println("Rectangle area: " + FigureUtil.area(rectangle));
        System.out.println("Rectangle perimeter: " + FigureUtil.perimeter(rectangle));
        FigureUtil.draw(rectangle, Color.RED);

        System.out.println("Square area: " + FigureUtil.area(square));
        System.out.println("Square perimeter: " + FigureUtil.perimeter(square));
        FigureUtil.draw(square, Color.BLUE);

        System.out.println("Triangle area: " + FigureUtil.area(triangle));
        System.out.println("Triangle perimeter: " + FigureUtil.perimeter(triangle));
        FigureUtil.draw(triangle, Color.GREEN);
    }
}