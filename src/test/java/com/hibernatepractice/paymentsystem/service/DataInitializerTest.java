package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.repository.OverdueAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DataInitializerTest {

    @Autowired
    private OverdueAccountRepository repository;

    @Test
    void testDataWasInitializedOnStartup() {
        // Since CommandLineRunner runs on startup,
        // the count should be at least 2 immediately.
        long count = repository.count();
        assertTrue(count >= 2, "Database should be pre-populated with at least 2 sample accounts");
    }
}