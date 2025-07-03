package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // без try catch работать не будет
        // оказывается для работы с файлами, нужно добавлять исключения для их обработки
        try {
            File file = new File("text.txt");
            Scanner scanner = new Scanner(file);
            Map<String, Integer> dict = new HashMap<>();
    
            // Scanner.hasNextLine() - проверяет строки для чтения
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
    
                for(String word : words) {
                    if(word.isEmpty()) continue;
    
                    word = word.toLowerCase();
    
                    // containsKey() - существует ли указанный ключ в мапе
                    // если слово есть в словаре - увеличиваем счетчик
                    if(dict.containsKey(word)) dict.put(word, dict.get(word) + 1);
                    // если слова нет, то кладем его в словарь
                    else dict.put(word, 1);
                }
            }
            scanner.close();
    
            System.out.println("Result");
            for(String word: dict.keySet()) 
                System.out.println(word + ": " + dict.get(word));
        } catch (FileNotFoundException e) {
            System.err.println("Error: File didn`t find");
        }
    }
}