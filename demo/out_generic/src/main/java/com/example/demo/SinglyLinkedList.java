package com.example.demo;
/*
 * элементы в связном списке связаны с помощью указателей
 */
public class SinglyLinkedList {
    Node head;

    // узел
    static class Node {
        int data;
        Node next; // следующий узел

        // конструктор для нового узла
        // следующий узел инициализирован как нулевой
        Node(int d) { 
            data = d;
            next = null;
        }
    }

    // вставка следующего узла
    public static SinglyLinkedList insert(SinglyLinkedList list, int data) {
        Node newNode = new Node(data);

        /*
         * нужно для проверки пустоты связанного списа, если он пуст, то он создаст новый узел как заглавный
         * если список не пуст, то перебирем до последнего узла и вставляем туда новый
         */
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    // вывод списка: выводит узел и переходит к следующему
    public static void printList(SinglyLinkedList list) {
        Node curNode = list.head;

        System.out.println("Singly Linked List: ");

        while(curNode != null) {
            System.out.println(curNode.data + " ");
            curNode = curNode.next;
        }
    }
}