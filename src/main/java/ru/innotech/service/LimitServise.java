package ru.innotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innotech.entity.Limit;
import ru.innotech.exception.LimitNotFound;
import ru.innotech.repo.LimitRepo;

@Service
public class LimitServise {
    LimitRepo limitRepo;

    @Autowired
    public LimitServise(LimitRepo limitRepo) {
        this.limitRepo = limitRepo;
    }

    public Limit findLimit(long userId) {
        Limit limit = limitRepo.findFirstByUserId(userId);
        if (limit == null) throw new LimitNotFound(); // если не найден лимит пользователя,то кидаем исключение
        return limit;
    }
}
