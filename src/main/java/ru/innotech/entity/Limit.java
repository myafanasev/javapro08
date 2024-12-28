package ru.innotech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "limits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Limit {
    @Id
    @Column(name = "user_id")
    long userId;
    double amount;
}
