package com.example.sber;

import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

/*
 * Scanner - класс для ввода с клавиатуры
 * n.charAt(t) - возвращает символ из строки n по индексу i
 * Character - класс, предоставляющий методы для работы с символами
 * Character.toString() - преобразует символ в строку
 * Integer - класс для int, числа -> объекты
 * Integer.parseInt() - преобразует строку в целочего число
 * final - константа
 * vector.get() - получение элмента из контейнера
 * vector.add() - добавить элемент в контейнер
 */

public class Main {

    // 1 задание
    static void printGreeting() {
        System.out.println("Hello, world!");
    }

    // 2 задание
    static void division(int a, int b) {
        if (a == 0 || b == 0) {
            System.out.println("Division by zero isn`t allowed");
        } else {
            System.out.println(a + "/" + b + "=" + a / b + " и " + a % b + " в остатке");
        }
    }

    // 3 задание
    static void palindromValidator(String a) {
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                System.out.println("Number isn`t palindrom");
                return;
            }
        }
        System.out.println("Number is palindrom");
    }

    // 4 задание
    static void sumOfDigit(String n) {
        if (n.length() != 3) {
            System.out.println("Repeat input");
            return;
        }
        int sum = 0;
        for (int i = 0; i < n.length(); ++i) {
            sum += Integer.parseInt(Character.toString(n.charAt(i)));
        }
        System.out.println("Sum of " + n + ": " + sum);
    }

    // задание 5
    static void earthToMoon(double a) {
        final double k = 0.17;
        System.out.println(a * k);
    }

    // задание 6
    static void validRegularNumber(int a) {
        int count = 0;
        for (int i = 1; i <= a; ++i) {
            if (a % i == 0) count += 1;
        }
        if (count > 2) System.out.println("Number isn`t regular");
        else System.out.println("Number is regular");
    }

    // задание 7
    static void fibonachi(int n) {
        Vector<Integer> v = new Vector<Integer>();
        if (n >= 1) v.add(0);
        if (n >= 2) v.add(1);
        for (int i = 2; i < n; i++)
            v.add(v.get(i-1) + v.get(i-2));
        System.out.println("Numbers fibonachi: " + v);
    }

    // задание 8
    static char genRandomLetter() {
        Random randChar = new Random();
        return (char) (randChar.nextInt(26) + 'A');
    }
    static final char targetLetter = genRandomLetter(); // нельзя использовать глобальную переменную без static
    static void charToGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input a random char from alphabit: ");
        char gameChar = in.next().toUpperCase().charAt(0);
        game(gameChar);
        in.close();
    }
    static void game(char a) {
        for (int i = 0; i < 100; ++i) {
            if (a == targetLetter) {
                System.out.println("Game is right over!");
                return;
            }
            else if (a < targetLetter) System.out.print("U`re too low");
            else System.out.println("U`re too high"); 

            charToGame();
        }
    }

    // задание 9
    static void roots(double a, double b, double c) {
        double D = Math.pow(b, 2) - 4*a*c;
        if (D >= 0) {
            double root1 = (-b+Math.sqrt(D))/2*a;
            double root2 = (-b-Math.sqrt(D))/2*a;
            System.out.println("x1 = " + root1 + ", x2 = " + root2);
        } else System.out.println("No roots");
    }

    // задание 10
    static String decToRom(int a) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] coding = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; ++i) {
            while (a >= values[i]) {
                result.append(coding[i]);
                a -= values[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        printGreeting();

        division(21, 8);
        
        Scanner in = new Scanner(System.in);
        System.out.println("Input a random number: ");
        String strNumber = in.nextLine();
        palindromValidator(strNumber);


        System.out.println("Input a random number of 3 digits: ");
        String str3Number = in.nextLine();
        sumOfDigit(str3Number);

        System.out.println("Input a weight: ");        
        double weight = in.nextDouble();
        earthToMoon(weight);

        System.out.println("Input a random number: ");
        int valNumber = in.nextInt();
        validRegularNumber(valNumber);

        System.out.println("Input a number or digit when (1<N<100)");
        int nFibonachi = in.nextInt();
        fibonachi(nFibonachi);

        charToGame();

        System.out.println("Input 3 numbers: ");
        double aEx = in.nextDouble();
        double bEx = in.nextDouble();
        double cEx = in.nextDouble();
        roots(aEx, bEx, cEx);

        System.out.println("Input a random number: ");
        int decA = in.nextInt();
        System.out.println("Result: " + decToRom(decA));

        in.close();
    }
}