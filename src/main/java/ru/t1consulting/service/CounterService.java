package ru.t1consulting.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CounterService {

    /* метод: List<Map.Entry<Character, Long>> countCharacters(String text)
     *
     * 1. преобразование пришедшей строки в StringBuilder
     * 2. в цикле StringBuilder'a проверяется наличие символа в Map
     *       1. если символа еще нет в Map'e, то он добавлется в нее
     *       2. если символ уже существует в Map'e, то его значение увеличивается на 1
     * 3. сортируясь по значениям, готовая Map'a конвертируется в List<Map.Entry<Character, Long>>
     * */
    public List<Map.Entry<Character, Long>> countCharacters(String text) {
        StringBuilder incomingText = new StringBuilder(text.toLowerCase());

        Map<Character, Long> characterCounting = new TreeMap<>();

        for (int i = 0; i < incomingText.length(); i++) {
            Character currentChar = incomingText.charAt(i);

            if (!characterCounting.containsKey(currentChar)) {
                characterCounting.put(currentChar, 1L);
            } else {
                Long numOfRepetitions = characterCounting.get(currentChar);
                characterCounting.put(currentChar, ++numOfRepetitions);
            }
        }

        List<Map.Entry<Character, Long>> numOfCharacters = characterCounting
                .entrySet()
                .stream()
                .sorted((pair1, pair2) -> -pair1.getValue().compareTo(pair2.getValue()))
                .collect(Collectors.toList());

        return numOfCharacters;
    }

}
