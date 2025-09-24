package com.example.banking.service;

import com.example.banking.entity.Transaction;
import com.example.banking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public Transaction create(Transaction tx) {
        tx.setCreatedAt(LocalDateTime.now());
        if (tx.getAmount() == null || tx.getAmount().doubleValue() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be positive");
        }
        return repository.save(tx);
    }

    public Page<Transaction> list(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Transaction update(Long id, Transaction newTx) {
        return repository.findById(id).map(tx -> {
            if (newTx.getAmount() != null && newTx.getAmount().doubleValue() > 0) {
                tx.setAmount(newTx.getAmount());
            }
            if (newTx.getType() != null) {
                tx.setType(newTx.getType());
            }
            if (newTx.getDescription() != null) {
                tx.setDescription(newTx.getDescription());
            }
            return repository.save(tx);
        }).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public Transaction getTransactionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Transaction with ID " + id + " not found."));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Transaction not found");
        }
        repository.deleteById(id);
    }
}
