package com.hibernatepractice.paymentsystem.repository;



import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvancedPaymentRepository extends JpaRepository<PaymentTransaction, Long> {
    // JpaRepository provides saveAndFlush() automatically
}