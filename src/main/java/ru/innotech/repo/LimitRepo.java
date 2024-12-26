package ru.innotech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innotech.entity.Limit;

public interface LimitRepo extends JpaRepository<Limit, Long> {
    Limit findFirstByUserId(long userId); // получение лимита пользователя
}
