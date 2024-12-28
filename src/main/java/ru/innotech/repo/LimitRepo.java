package ru.innotech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.innotech.entity.Limit;

public interface LimitRepo extends JpaRepository<Limit, Long> {
    Limit findFirstByUserId(long userId); // получение лимита пользователя

    @Modifying
    @Query("update Limit set amount = ?1") // установка всем пользователям значения лимита
    void resetLimit(double value);
}
