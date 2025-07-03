package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> curMap = new HashMap<>();
        curMap.put(1, "One");
        curMap.put(2, "Two");
        curMap.put(3, "Three");

        System.out.println("Настоящая мапа: " + curMap);
        
        Map<String, Integer> swappedMap = MapTemplate.swaper(curMap);
        System.out.println("Мапа с изменными местами: " + swappedMap);    }
}