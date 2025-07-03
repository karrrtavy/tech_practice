package com.example.demo;

// интерфейс определяет контракт для рисования фигур
// фигуры могут реализовать эти методы по своему
public interface Drawable {
    void draw();
    void draw(Color color);
}
