package ru.t1consulting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.t1consulting.model.CheckedText;
import ru.t1consulting.service.CounterService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counter")
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    /*
     * ожидается запрос: "http://localhost:8080/counter" с JSON-объектом: {"text": "J aaAa abcc,,*cc"}
     * значение JSON-объекта может включать пробелы, но не может быть null, иначе ошибка -- MethodArgumentNotValidException
     * */
    @PostMapping
    public List<Map.Entry<Character, Long>> countCharacters(@Valid @RequestBody CheckedText checkedText) {
        return counterService.countCharacters(checkedText.getText());
    }

    /*
     * ожидается запрос с переменной пути: "http://localhost:8080/counter/{text}", где вместо "text" подставляется
     * нужная фраза: "http://localhost:8080/counter/J aaAa abcc,,*cc
     * перменная пути должна быть заполнена, иначе ошибка -- Throwable
     * */
    @GetMapping("/{text}")
    public List<Map.Entry<Character, Long>> countCharacters(@Valid @PathVariable String text) {
        return counterService.countCharacters(text);
    }
}
