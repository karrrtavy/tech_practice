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

public class Main {
    public static void main(String[] args) {
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