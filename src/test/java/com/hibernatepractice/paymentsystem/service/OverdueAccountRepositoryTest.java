package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.OverdueAccount;
import com.hibernatepractice.paymentsystem.repository.OverdueAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.flyway.enabled=false",
        "spring.jpa.hibernate.ddl-auto=update"
})
public class OverdueAccountRepositoryTest {

    @Autowired
    private OverdueAccountRepository repository;

    @Test
    public void testSaveAndRetrieveAccount() {
        OverdueAccount account = new OverdueAccount(101L, new BigDecimal("1000.00"), BigDecimal.ZERO);
        repository.save(account);

        OverdueAccount retrieved = repository.findById(101L).orElse(null);
        assertNotNull(retrieved);
        assertEquals(0, new BigDecimal("1000.00").compareTo(retrieved.getPrincipalAmount()));
    }
}