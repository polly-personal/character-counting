package ru.t1consulting.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandlerController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.warn("🟥 ERROR: ошибка валидации. " + e.getMessage());
        return "🟥ERROR: ошибка валидации. " + e.getMessage();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleThrowable(final Throwable e) {
        log.warn("🟥 ERROR: произошла непредвиденная ошибка. " + e.getMessage());
        return "🟥ERROR: произошла непредвиденная ошибка. " + e.getMessage();
    }
}
