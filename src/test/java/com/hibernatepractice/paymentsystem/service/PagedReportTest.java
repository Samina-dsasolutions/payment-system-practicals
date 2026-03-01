package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import com.hibernatepractice.paymentsystem.repository.PaymentTransactionRepository;
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

    @Test
    void testPagingAndSorting() {
        // 1. Setup: Create 5 transactions
        for (int i = 0; i < 5; i++) {
            PaymentTransaction tx = new PaymentTransaction();
            tx.setAmount(new BigDecimal(10 * (i + 1)));
            tx.setStatus("COMPLETED");
            repository.save(tx);
        }

        // 2. Request Page 0 with size 2, sorted by amount descending
        Page<PaymentTransaction> pagedData = repository.findAll(
                PageRequest.of(0, 2, Sort.by("amount").descending())
        );

        // 3. Assertions
        assertEquals(2, pagedData.getContent().size());
        assertEquals(5, pagedData.getTotalElements());
        assertEquals(0, new BigDecimal("50.00").compareTo(pagedData.getContent().get(0).getAmount()));
    }
}