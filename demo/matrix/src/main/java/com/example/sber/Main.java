package com.example.sber;

// third task
class Matrix {
    private final int[][] numbers;
    private final int rows;   // i
    private final int columns;    // j

    // Matrix result = new Matrix(rows, columns);  // заметил ошибку, такая реализация не работает, матрицы бесконечно рекурсивно создаются, пока не переполнится стек

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.numbers = new int[rows][columns];
    }

    public void setValue(int i, int j, int value) {
        if (i >= 0 && i < rows && j >= 0 && j < columns)
            numbers[i][j] = value;
    }

    // Matrix other - другой объект класса Matrix
    // альтернативно можно использовать add(Matrix a, Matrix b);
    public Matrix addition(Matrix other) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < columns; ++j)
                result.numbers[i][j] = this.numbers[i][j] + other.numbers[i][j];
        return result;
    }
    public Matrix multiply(int number) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < columns; ++j)
                result.numbers[i][j] = this.numbers[i][j] * number;
        return result;
    }
    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < columns; ++j)
                result.numbers[i][j] = this.numbers[i][j] * other.numbers[i][j];
        return result;
    }

    public void printM() {
        System.out.println("Matrix: ");
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j)
                System.out.print(numbers[i][j] + " ");
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // third task
        System.out.println("Third task");
        Matrix marr1 = new Matrix(5, 5);
        Matrix marr2 = new Matrix(5, 5);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                marr1.setValue(i, j, i + j);
                marr2.setValue(i, j, i + j);
            }
        }

        marr1.printM();
        marr2.printM();

        marr1.addition(marr2).printM();

        marr1.multiply(5).printM();

        marr1.multiply(marr2).printM();
    }
}