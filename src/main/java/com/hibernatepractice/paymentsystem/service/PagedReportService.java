package com.hibernatepractice.paymentsystem.service;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import com.hibernatepractice.paymentsystem.repository.PaymentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PagedReportService {

    @Autowired
    private PaymentTransactionRepository repository;

    public void generateLargeScaleReport(String status) {
        int pageSize = 100; // Fetch 100 records at a time
        Page<PaymentTransaction> page = repository.findByStatus(
                status,
                PageRequest.of(0, pageSize, Sort.by("id").ascending())
        );

        while (page.hasContent()) {
            page.getContent().forEach(tx -> {
                // Process report logic for each transaction
                System.out.println("Reporting Transaction ID: " + tx.getId());
            });

            if (!page.hasNext()) break;

            // Fetch next page
            page = repository.findByStatus(status, page.nextPageable());
        }
    }
}