package com.hibernatepractice.paymentsystem.service;


import com.hibernatepractice.paymentsystem.model.PaymentEntity;
import com.hibernatepractice.paymentsystem.repository.PaymentEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.flyway.enabled=false",
        "spring.jpa.hibernate.ddl-auto=update"
})
public class PaymentEntityLeakageTest {

    @Autowired
    private PaymentEntityRepository repository;

    @Test
    public void testIdLeakageManifestation() {
        PaymentEntity payment = new PaymentEntity();
        payment.setAmount(new BigDecimal("150.00"));
        payment.setCurrency("USD");

        // Before saving, the "leaked" ID is null
        assertNull(payment.getId());

        // Save to the relational database
        PaymentEntity savedPayment = repository.save(payment);

        // After saving, the relational model has "leaked" an ID back into our object
        assertNotNull(savedPayment.getId());
        System.out.println("Relational Leakage - Generated ID: " + savedPayment.getId());
    }
}