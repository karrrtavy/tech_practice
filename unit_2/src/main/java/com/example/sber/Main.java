package com.example.sber;

import java.util.Arrays;

class Phone {
    private String number;
    private String model;
    private double weight;

    Phone() {}   // нужно прописывать геттеры и сеттеры на пустой конструктор?
    Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }
    Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    void receiveCall(String incName) {
        System.out.println("Звонит " + incName);
    }
    void receiveCall(String incName, String incNumber) {
        System.out.println("Звонит " + incName + " с номера " + incNumber);
    }

    public String getNumber(String get_num) {
        return get_num;
    }

    void sendMessage(String[] numbers) {
        System.out.println("Массовая отправка сообщений на: " + Arrays.toString(numbers));
    }

    @Override   
    public String toString() {  // сначала не понял, что значит реализовать метод toString, только потом понял что нужно его переопределить
        // нельзя переопределить если метод будет любым другим, кроме String
        return "Телефон: " + number + ", " + model + ", " + weight;
    }

    // методы, которые что либо возвращают - должны оставаться публичными, иначе ошибки
}

// second task
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

// fourth task
class Author {
    private String aName;
    private String gender;
    private String email;

    public Author(String aName, String gender, String email) {
        this.aName = aName;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return aName;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String aName) {
        this.aName = aName;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setMail(String email) {
        this.email = email;
    }


}

// не применяем явное наследование Author, но создаем Author объект в Book
class Book {
    private String name;
    private Author author;
    // можно объявить как String, но будет занимать больше памяти, проще добавить процесс валидации на длину, через преобразование int в String
    private int year;  

    public Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }
    public Author getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Книга: " + name + " Автор: " + author.getName() + " Год: " + year;
    }

}

// fivth task

class PizzaOrder {
    private String name;
    private String addressDelivery;
    enum Size { SMALL, MEDIUM, BIG };
    private Size size;
    private boolean needSauce;

    public boolean acceptOrder;

    public PizzaOrder(String name, Size size, boolean needSauce, String addressDelivery) {
        this.name = name;
        this.size = size;
        this.addressDelivery = addressDelivery;
        this.acceptOrder = false;
        this.needSauce = needSauce;
    }

    public String getName() {
        return name;
    }
    public String getAddressDelivery() {
        return addressDelivery;
    }
    public Size getSize() {
        return size;
    }
    public boolean isNeedSauce() {
        return needSauce;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddressDelivery(String addressDelivery) {
        this.addressDelivery = addressDelivery;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public void setNeedSauce(boolean needSauce) {
        this.needSauce = needSauce;
    }

    public void order() {
        if (acceptOrder) {
            System.out.println("Заказ уже был принят");
        } else {
            acceptOrder = true;
            if (needSauce) System.out.println("Заказ принят: " + size + " пицца с соусом на адрес" + addressDelivery);
            else System.out.println("Заказ принят: " + size + " пицца без соуса на адрес " + addressDelivery);
        }
    }
    public void cancel() {
        if (acceptOrder) {
            acceptOrder = false;
            System.out.println("Заказ отменен");
        } else {
            System.out.println("Заказ не был принят");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // fivth task
        System.out.println("Fivth task:");
        PizzaOrder order1 = new PizzaOrder("4 сыра", PizzaOrder.Size.BIG, false, "Галкинская 1");

        order1.order();
        order1.order();

        order1.cancel();
        order1.cancel();

        // fourth task
        System.out.println("Fourth task:");
        Author author = new Author("Федор Достоевский", "Male", "dostoevsky@mail.li");

        Book book = new Book("Бесы", author, 1871);

        System.out.println(book.toString());



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

        // second task
        System.out.println("Second task:"); 
        Circle figure = new Circle(2.54, "красный");
        System.out.println(figure.toString());

        // first task
        System.out.println("First task:");
        Phone phone_1 = new Phone("+78005553535", "апфоин 15", 0.267);
        Phone phone_2 = new Phone("+71234567890", "сасунг 22 эс");
        Phone phone_3 = new Phone();

        phone_1.receiveCall("Оператор 1");
        phone_2.receiveCall("Друг дружбан дружище", "+79110010203");

        phone_3.sendMessage(new String[]{"+01234567890", "+11234567890", "+21234567890"});

        System.out.println(phone_3.toString());

    }
}