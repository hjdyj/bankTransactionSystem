package com.example.banking.controller;

import com.example.banking.entity.Transaction;
import com.example.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @PostMapping
    public Transaction create(@RequestBody Transaction tx) {
        return service.create(tx);
    }

    @GetMapping
    public Page<Transaction> list(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return service.list(page, size);
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id, @RequestBody Transaction tx) {
        return service.update(id, tx);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
