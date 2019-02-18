package com.talan.banking.transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	

	public Transaction findById(int id);
	public List<Transaction> findByPayerid(int accountid);
	public List<Transaction> findByPayeeid(int accountid);
	public List<Transaction> findAll();
	public Transaction save(Transaction transaction);
	public Transaction saveAndFlush(Transaction transaction);

}
