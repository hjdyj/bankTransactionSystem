package com.example.banking;

import com.example.banking.entity.Transaction;
import com.example.banking.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;


    @Test
    void testCreateTransaction() {
        Transaction tx = new Transaction(1L, "DEPOSIT", new BigDecimal("500.00"), "test deposit");
        Transaction saved = transactionService.create(tx);
        assertEquals(500.0, saved.getAmount());
    }


    @Test
    void testFindTransactionById() {
        Transaction tx = new Transaction(2L, "WITHDRAWAL", new BigDecimal("500.00"), "test withdraw");
        transactionService.create(tx);
        Transaction found = transactionService.getTransactionById(2L);
        assertNotNull(found);
        assertEquals("WITHDRAWAL", found.getType());
    }
}
