package com.hibernatepractice.paymentsystem.repository;


import com.hibernatepractice.paymentsystem.model.PaymentTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RefundRepository extends BasePaymentRepository<PaymentTransaction, Long> {

    @Override
    @Query("SELECT p FROM PaymentTransaction p WHERE p.status = 'ACTIVE'")
    List<PaymentTransaction> findAllActive();
}