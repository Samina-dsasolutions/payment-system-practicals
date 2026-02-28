package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.OverdueAccount;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;



import com.hibernatepractice.paymentsystem.model.OverdueAccount;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class OverdueAccountEqualityTest {

    @Test
    void testEqualityBasedOnId() {
        // Use the 3-argument constructor: (accountId, principalAmount, accruedInterest)
        OverdueAccount acc1 = new OverdueAccount(101L, new BigDecimal("100.00"), BigDecimal.ZERO);
        OverdueAccount acc2 = new OverdueAccount(101L, new BigDecimal("999.00"), BigDecimal.ZERO);

        // They should be equal because the accountId (the @Id) is the same
        assertEquals(acc1, acc2);
        assertEquals(acc1.hashCode(), acc2.hashCode());
    }

    @Test
    void testInequalityWithDifferentIds() {
        OverdueAccount acc1 = new OverdueAccount(101L, new BigDecimal("100.00"), BigDecimal.ZERO);
        OverdueAccount acc2 = new OverdueAccount(102L, new BigDecimal("100.00"), BigDecimal.ZERO);

        assertNotEquals(acc1, acc2);
    }
}