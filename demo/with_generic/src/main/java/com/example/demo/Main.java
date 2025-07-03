package com.example.demo;

public class Main {
    public static void main(String[] args) {
        // реализация списка с дженериками (те же шаблоны в плюсах) может работать с любым типом
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<>();
        for (int i = 1; i <= 10; ++i) {
            intList.insert(i);
        }
        intList.printList();

        SinglyLinkedList<String> strList = new SinglyLinkedList<>();
        strList.insert("Hello");
        strList.insert("World");
        strList.insert("Java");
        strList.printList();
    }
}