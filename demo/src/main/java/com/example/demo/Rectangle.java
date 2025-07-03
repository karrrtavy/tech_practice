package com.example.demo;

public class Rectangle extends Figure {
    /*
     * заметил, что инкапсуляция нарушалась при прямом доступе к приваткам
     * дочерние классы не видят эти поля, поэтому используем protected
     * пробовал с геттером на width, но не помогло
     */
    protected double width;
    protected double height;

    public Rectangle(double width, double height, Point point) {
        super(point, Color.BLACK);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw(Color color) {
        System.out.println("Rectangle: cords " + "(" + point.getX() + ", " + point.getY() + ")" +
                            ", height and width: " + height + ", " + width + ", color: " + color);
    }
}