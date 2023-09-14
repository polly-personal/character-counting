package ru.t1consulting.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.t1consulting.model.CheckedText;
import ru.t1consulting.service.CounterService;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayName("CounterControllerTest должен ")
public class CounterControllerTest {
    private static CounterController counterController;

    @BeforeAll
    public static void createCounterController() {
        counterController = new CounterController(new CounterService());
    }

    @DisplayName("подсчитывать количество символов из переданного JSON-объекта")
    @Test
    public void countCharactersFromJson() {
        CheckedText checkedText = new CheckedText("J aaAa abcc,,*cc");
        List<Map.Entry<Character, Long>> result = counterController.countCharacters(checkedText);

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

    @DisplayName("подсчитывать количество символов из переданной строки")
    @Test
    public void countCharactersFromString() {
        CheckedText checkedText = new CheckedText("J aaAa abcc,,*cc");
        List<Map.Entry<Character, Long>> result = counterController.countCharacters(checkedText.getText());

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
