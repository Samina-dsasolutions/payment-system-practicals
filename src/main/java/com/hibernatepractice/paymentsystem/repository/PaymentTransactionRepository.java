package com.hibernatepractice.paymentsystem.repository;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
    // Inherits findByStatus(String status, Pageable pageable) automatically
    Page<PaymentTransaction> findByStatus(String status, Pageable pageable);
}