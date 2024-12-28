package ru.innotech.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innotech.entity.Limit;
import ru.innotech.exception.LimitExceeding;
import ru.innotech.exception.LimitNotFound;
import ru.innotech.exception.PaymentFailed;
import ru.innotech.repo.LimitRepo;

import java.util.Random;

@Service
public class LimitServise {
    static final double limitDefault = 10000;
    LimitRepo limitRepo;

    @Autowired
    public LimitServise(LimitRepo limitRepo) {
        this.limitRepo = limitRepo;
    }

    public boolean executePayment() { // заглушка для сервиса платежей
        return new Random().nextBoolean();
    }

    public Limit creationDefaultLimit(long userId) {    // создание лимита по умолчанию для нового пользователя
        Limit limit = new Limit(userId, limitDefault);
        limitRepo.save(limit);
        return limit;
    }

    public Limit findLimit(long userId) {   // поиск лимита пользователя
        Limit limit = limitRepo.findFirstByUserId(userId);
        if (limit == null) limit = creationDefaultLimit(userId); // если не найден лимит пользователя, то создаём его со значением по умолчанию
        return limit;
    }

    @Transactional
    public Limit decrementLimit(long userId, double sum) {
        Limit limit = findLimit(userId);
        if (limit.getAmount() < sum) throw new LimitExceeding(); // если лимит превышен, кидаем исключение
        limit.setAmount(limit.getAmount() - sum); // уменьшаем лимит
        if (!executePayment()) throw new PaymentFailed();   // если платёж не был исполнен, кидаем исключение
        limitRepo.save(limit);  // сохраняем новый лимит
        return limit;
    }
}
