package ru.innotech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.innotech.entity.Limit;
import ru.innotech.service.LimitServise;

@RestController
public class RestLimitController {
    LimitServise limitServise;

    @Autowired
    public RestLimitController(LimitServise limitServise) {
        this.limitServise = limitServise;
    }

    @GetMapping("/getLimit")
    // поиск лимита клиента
    public Limit getLimit(@RequestParam("id") long userId) { // получить лимит по ID пользователя
        return limitServise.findLimit(userId);
    }

    @GetMapping("/decrementLimit")
    // уменьшение лимита, возвращает новый лимит после уменьшения
    public Limit decrementLimit(@RequestParam("id") long userId, @RequestBody double sum) {
        return limitServise.decrementLimit(userId, sum);
    }
}
