package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BatchPaymentService {
    private static final Logger logger = LoggerFactory.getLogger(BatchPaymentService.class);
    private final InterestService interestService;

    public BatchPaymentService(InterestService interestService) {
        this.interestService = interestService;
    }

    public void processAutoDebits(List<Account> overdueAccounts) {
        for (Account account : overdueAccounts) {
            try {
                // Logic for calculating due amount + interest
                // We use the calculate method from our previous exercise
                BigDecimal interest = interestService.calculate(account.getBalance(), 30);
                BigDecimal totalDue = account.getBalance().add(interest);

                // Simulate debit logic
                logger.info("Successfully debited {} from Account: {}", totalDue, account.getId());

            } catch (Exception e) {
                // Professional error handling for partial failures in batches
                logger.error("Failed to process account: " + account.getId(), e);
            }
        }
    }
}