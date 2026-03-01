package com.hibernatepractice.paymentsystem.bootstrap;



import com.hibernatepractice.paymentsystem.model.OverdueAccount;
import com.hibernatepractice.paymentsystem.repository.OverdueAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentDataInitializer implements CommandLineRunner {

    private final OverdueAccountRepository accountRepository;

    // Best Practice: Constructor Injection
    public PaymentDataInitializer(OverdueAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Starting Data Initialization ---");

        // Create sample overdue accounts
        OverdueAccount acc1 = new OverdueAccount(101L, new BigDecimal("500.00"), BigDecimal.ZERO);
        OverdueAccount acc2 = new OverdueAccount(102L, new BigDecimal("1200.50"), BigDecimal.ZERO);

        // Save to MySQL
        accountRepository.save(acc1);
        accountRepository.save(acc2);

        System.out.println("Total Accounts Initialized: " + accountRepository.count());
        System.out.println("--- Data Initialization Complete ---");
    }
}