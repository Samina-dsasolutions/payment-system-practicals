package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import com.hibernatepractice.paymentsystem.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.flyway.enabled=false",
        "spring.jpa.hibernate.ddl-auto=update"
})
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository repository;

    @Test
    public void testFindByStatus() {
        PaymentTransaction tx = new PaymentTransaction();
        tx.setAmount(new BigDecimal("250.00"));
        tx.setStatus("PENDING");
        repository.save(tx);

        List<PaymentTransaction> results = repository.findByStatus("PENDING");
        assertFalse(results.isEmpty());
        assertEquals("PENDING", results.get(0).getStatus());
    }
}