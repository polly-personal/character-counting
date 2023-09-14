package ru.t1consulting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CharacterCountingApplication {
    /*
     * приложение запускается через main-метод класса CharacterCountingApplication
     *
     * способы проверки API:
     *   1. через Postman
     *   2. через браузерную строку
     * */
    public static void main(String[] args) {
        SpringApplication.run(CharacterCountingApplication.class, args);
    }

}
