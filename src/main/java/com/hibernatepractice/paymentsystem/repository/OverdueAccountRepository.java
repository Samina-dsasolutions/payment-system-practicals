package com.hibernatepractice.paymentsystem.repository;



import com.hibernatepractice.paymentsystem.model.OverdueAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OverdueAccountRepository extends CrudRepository<OverdueAccount, Long> {
}