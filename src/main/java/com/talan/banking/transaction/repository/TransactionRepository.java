package com.talan.banking.transaction.repository;

import java.util.List;

import com.talan.banking.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	

	Transaction findById(int id);
	List<Transaction> findByPayerid(int accountid);
	List<Transaction> findByPayeeid(int accountid);
	List<Transaction> findAll();
	Transaction save(Transaction transaction);
	Transaction saveAndFlush(Transaction transaction);

}
