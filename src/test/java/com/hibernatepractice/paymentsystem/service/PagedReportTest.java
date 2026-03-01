package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import com.hibernatepractice.paymentsystem.repository.PaymentTransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class PagedReportTest {

    @Autowired
    private PaymentTransactionRepository repository;

    @BeforeEach
    void setUp() {
        // Clear previous test data to ensure isolation
        repository.deleteAll();
    }

    @Test
    void testPagingAndSorting() {
        // Setup: Create 5 transactions
        for (int i = 0; i < 5; i++) {
            PaymentTransaction tx = new PaymentTransaction();
            tx.setAmount(new BigDecimal(10 * (i + 1)));
            tx.setStatus("COMPLETED");
            repository.save(tx);
        }

        // Fetch Page
        Page<PaymentTransaction> pagedData = repository.findAll(
                PageRequest.of(0, 2, Sort.by("amount").descending())
        );

        // Now this will correctly expect 5
        assertEquals(5, pagedData.getTotalElements());
    }
}