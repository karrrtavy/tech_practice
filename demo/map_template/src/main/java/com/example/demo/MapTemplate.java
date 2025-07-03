package com.example.demo;

import java.util.Map;
import java.util.HashMap;


public class MapTemplate {
    public static <K, V> Map<V, K> swaper(Map<K, V> map) {
        Map<V, K> swappedMap = new HashMap<>();
        
        // просто в новую мапу кладем K V из первой мапы, но просто в другом порядке
        // entrySet() полезен тем, что можно получить доступ одновременно к ключу и значению
        for(Map.Entry<K,V> entry : map.entrySet())
            swappedMap.put(entry.getValue(), entry.getKey());

        return swappedMap;
    }
}