package ru.innotech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.innotech.exception.LimitNotFound;

@ControllerAdvice
public class ExceptionLimitController {
    @ExceptionHandler(LimitNotFound.class)
    public ResponseEntity<String> notFoundLimit() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Не найден лимит пользователя");
    }
}