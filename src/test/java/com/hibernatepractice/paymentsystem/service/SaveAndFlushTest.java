package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SaveAndFlushTest {

    @Autowired
    private AutoDebitService autoDebitService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional // The flush happens inside this transaction
    void testImmediateDatabaseVisibility() {
        BigDecimal amount = new BigDecimal("150.00");

        // Execute service method
        PaymentTransaction savedTx = autoDebitService.executeAutoDebit(amount);

        // Standard save() would wait until the end of this test method to send SQL.
        // saveAndFlush() sent it already. We verify via raw JDBC.
        Map<String, Object> result = jdbcTemplate.queryForMap(
                "SELECT * FROM payment_transaction WHERE id = ?", savedTx.getId()
        );

        assertNotNull(result);
        assertEquals("INITIATED", result.get("status"));
        System.out.println("Verified immediate visibility in MySQL for ID: " + savedTx.getId());
    }
}