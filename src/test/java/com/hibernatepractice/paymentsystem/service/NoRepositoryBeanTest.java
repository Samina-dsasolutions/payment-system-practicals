package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import com.hibernatepractice.paymentsystem.repository.RefundRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoRepositoryBeanTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RefundRepository refundRepository;

    @BeforeEach
    void setUp() {
        // Clear shared table to prevent 'expected 1 but was 2' error
        refundRepository.deleteAll();
    }

    @Test
    void verifyNoRepositoryBeanBehavior() {
        // Verify Spring ignored the base interface
        boolean baseBeanExists = context.containsBean("basePaymentRepository");
        assertFalse(baseBeanExists);

        // Verify the child repository works in isolation
        PaymentTransaction tx = new PaymentTransaction();
        tx.setAmount(new BigDecimal("50.00"));
        tx.setStatus("ACTIVE");
        refundRepository.save(tx);

        List<PaymentTransaction> actives = refundRepository.findAllActive();
        assertEquals(1, actives.size(), "Should find exactly 1 record after clearing the DB");
    }
}