package ru.innotech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.innotech.exception.LimitExceeding;
import ru.innotech.exception.LimitNotFound;
import ru.innotech.exception.PaymentFailed;

@ControllerAdvice
public class ExceptionLimitController {
    @ExceptionHandler(LimitNotFound.class)
    public ResponseEntity<String> notFoundLimit() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Не найден лимит пользователя");
    }
    @ExceptionHandler(LimitExceeding.class)
    public ResponseEntity<String> exceedingLimit() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Лимит превышен");
    }

    @ExceptionHandler(PaymentFailed.class)
    public ResponseEntity<String> paymentFaile() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Платёж не исполнен");
    }
}