package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.model.OverdueAccount;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class OverdueAccountEqualityTest {

    @Test
    void testEqualityBasedOnId() {
        // Create two objects with the same ID but different amounts
        OverdueAccount acc1 = new OverdueAccount(1L, 101L, new BigDecimal("100.00"), BigDecimal.ZERO);
        OverdueAccount acc2 = new OverdueAccount(1L, 101L, new BigDecimal("999.00"), BigDecimal.ZERO);

        // They should be equal because the ID is the same
        assertEquals(acc1, acc2);
        assertEquals(acc1.hashCode(), acc2.hashCode());
    }

    @Test
    void testInequalityWithDifferentIds() {
        OverdueAccount acc1 = new OverdueAccount(1L, 101L, new BigDecimal("100.00"), BigDecimal.ZERO);
        OverdueAccount acc2 = new OverdueAccount(2L, 101L, new BigDecimal("100.00"), BigDecimal.ZERO);

        assertNotEquals(acc1, acc2);
    }

    @Test
    void testNewObjectsWithNullId() {
        // Two new objects without IDs should only be equal if they are the same instance
        OverdueAccount acc1 = new OverdueAccount();
        OverdueAccount acc2 = new OverdueAccount();

        // Objects.equals(null, null) returns true
        assertEquals(acc1, acc2);
    }
}