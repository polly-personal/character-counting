package ru.t1consulting.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("CounterServiceTest должен ")
public class CounterServiceTest {
    private static CounterService counterService;

    @BeforeAll
    public static void createCounterService() {
        counterService = new CounterService();
    }

    @DisplayName("вести подсчет символов")
    @Test
    public void countCharacters() {
        List<Map.Entry<Character, Long>> result = counterService.countCharacters("J aaAa abcc,,*cc");

        assertEquals(result.size(), 7);

        Map<Character, Long> expectedPairs = new TreeMap<>();
        expectedPairs.put('j', 1L);
        expectedPairs.put(' ', 2L);
        expectedPairs.put('a', 5L);
        expectedPairs.put('b', 1L);
        expectedPairs.put('c', 4L);
        expectedPairs.put(',', 2L);
        expectedPairs.put('*', 1L);

        List<Map.Entry<Character, Long>> actual = expectedPairs
                .entrySet()
                .stream()
                .sorted((pair1, pair2) -> -pair1.getValue().compareTo(pair2.getValue()))
                .collect(Collectors.toList());

        assertEquals(actual.get(0), result.get(0));
        assertEquals(actual.get(1), result.get(1));
        assertEquals(actual.get(2), result.get(2));
        assertEquals(actual.get(3), result.get(3));
        assertEquals(actual.get(4), result.get(4));
        assertEquals(actual.get(5), result.get(5));
        assertEquals(actual.get(6), result.get(6));
    }
}
