package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.model.Account;
import com.hibernatepractice.paymentsystem.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class BatchOptimizationTest {

    @Autowired
    private BatchOptimizationService batchService;

    @Autowired
    private AccountRepository repository;

    @Test
    void testBulkUpdateEfficiency() {
        // Setup multiple overdue accounts
        repository.save(new Account("ACC001", new BigDecimal("100.00"), "OVERDUE"));
        repository.save(new Account("ACC002", new BigDecimal("200.00"), "OVERDUE"));

        // Execute bulk update (5% interest)
        int updatedCount = batchService.processLargeScaleInterest(new BigDecimal("0.05"));

        assertEquals(2, updatedCount);

        // Verify one balance: 100 + (100 * 0.05) = 105.00
        BigDecimal newBalance = repository.findById("ACC001").get().getBalance();
        assertEquals(0, new BigDecimal("105.00").compareTo(newBalance));
    }
}