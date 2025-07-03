package com.example.demo;

public class Main {
    public static void main(String[] args) {
        // без дженериков данные списка могут принимать только один тип данных, объявленный в классе
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 1; i <= 10; ++i)
            list = SinglyLinkedList.insert(list, i);

        SinglyLinkedList.printList(list);
    }
}