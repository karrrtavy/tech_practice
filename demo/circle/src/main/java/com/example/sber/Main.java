package com.example.sber;

class Circle {
    private final double radius;
    private final String color;
    public final double PI = 3.14;

    Circle (double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area(double radius) {
        return PI * Math.pow(radius, 2);
    }
    public double perimetr(double radius) {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Радиус = " + radius + ", цвет = " + color + ", площадь = " + area(radius) + ", периметр = " + perimetr(radius);
    }

}

public class Main {
    public static void main(String[] args) {
        // second task
        System.out.println("Second task:"); 
        Circle figure = new Circle(2.54, "красный");
        System.out.println(figure.toString());
    }
}