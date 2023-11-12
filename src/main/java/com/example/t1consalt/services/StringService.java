package com.example.t1consalt.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StringService {

    public String countChars( String str){

        StringBuilder resultBuilder = new StringBuilder();
        // Создаем карту для подсчета частоты встречи символов
        Map<Character, Integer> charCount = new HashMap<>();

        // Подсчитываем частоту встречи символов
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        charCount.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry ->
                    resultBuilder.append("\"").append(entry.getKey()).append("\"").append(": ")
                            .append(entry.getValue()).append(", "));
        resultBuilder.setLength(resultBuilder.length() - 2);

        return resultBuilder.toString();
    }
}
