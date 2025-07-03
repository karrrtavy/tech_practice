package com.example.demo;


// общие свойства и методы для всех фигур
public abstract class Figure implements Drawable {
    protected Point point;
    protected Color color;

    public Figure(Point point, Color color) {
        this.point = point;
        this.color = color;
    } 

    public abstract double area();
    public abstract double perimeter();

    @Override
    public void draw() {
        draw(Color.BLACK);
    }
}