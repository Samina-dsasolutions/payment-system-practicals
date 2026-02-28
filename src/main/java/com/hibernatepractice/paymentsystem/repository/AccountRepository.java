package com.hibernatepractice.paymentsystem.repository;



import com.hibernatepractice.paymentsystem.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {

    @Modifying(clearAutomatically = true) // Important: Clears stale cache after bulk update
    @Transactional
    @Query(value = "UPDATE accounts SET balance = balance + (balance * :rate) WHERE status = 'OVERDUE'", nativeQuery = true)
    int bulkUpdateInterest(@Param("rate") BigDecimal rate);
}