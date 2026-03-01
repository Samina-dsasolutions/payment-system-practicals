package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import com.hibernatepractice.paymentsystem.repository.AdvancedPaymentRepository; // Import the repository
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
    private AdvancedPaymentRepository repository; // Add this to resolve the 'repository' error

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @Transactional
    void testImmediateDatabaseVisibility() {
        BigDecimal amount = new BigDecimal("150.00");
        PaymentTransaction savedTx = autoDebitService.executeAutoDebit(amount);

        Map<String, Object> result = jdbcTemplate.queryForMap(
                "SELECT * FROM payment_transaction WHERE id = ?", savedTx.getId()
        );

        assertNotNull(result);
        assertEquals("INITIATED", result.get("status"));
    }

    @Test
    @Transactional
    void verifySqlExecutionTiming() {
        System.out.println("--- Starting Test ---");

        PaymentTransaction tx = new PaymentTransaction();
        tx.setAmount(new BigDecimal("250.00"));
        tx.setStatus("FLUSH_TEST");

        System.out.println("--- Calling saveAndFlush() ---");
        repository.saveAndFlush(tx); // This will now resolve correctly

        System.out.println("--- saveAndFlush() finished ---");

        Integer count = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM payment_transaction WHERE status = 'FLUSH_TEST'", Integer.class
        );

        assertEquals(1, count, "Database should have received the record already!");
        System.out.println("--- Ending Test (Transaction Commits) ---");
    }
}