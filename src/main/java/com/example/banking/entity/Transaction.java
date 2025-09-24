package com.example.banking.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., deposit, withdraw
    private BigDecimal amount;
    private String description;
    private LocalDateTime createdAt;

    public Transaction(long id, String type, BigDecimal amount, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }
}
