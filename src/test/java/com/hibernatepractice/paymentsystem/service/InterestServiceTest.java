package com.hibernatepractice.paymentsystem.service;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class InterestServiceTest {

    @Autowired
    private InterestService interestService;

    @Test
    void testCalculateInterestWithMinimumFee() {
        // Verify our logic: 100 * 0.05 * 1 day = 5.00
        BigDecimal result = interestService.calculate(new BigDecimal("100.00"), 1);
        assertEquals(new BigDecimal("5.00"), result);
    }
}