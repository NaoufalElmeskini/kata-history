package com.talan.banking.transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	@Autowired
	private TransactionRepository repository;
	
	@GetMapping("/history/{accountid}")
	public List<Transaction> getTransactionHistory(@PathVariable int accountid){
		List<Transaction> transactionListAsAPayer = repository.findByPayerid(accountid);
		List<Transaction> transactionListAsAPayee = repository.findByPayeeid(accountid);
		
		List<Transaction> allTransactionList = new ArrayList<>();
		allTransactionList.addAll(transactionListAsAPayer);
		allTransactionList.addAll(transactionListAsAPayee);
		
		allTransactionList.sort(Comparator.comparing(Transaction::getDate));
		return allTransactionList;
	}
	
	@GetMapping("/history")
	public List<Transaction> getTransactionHistory(){
		
		List<Transaction> allTransactionList = repository.findAll();
		allTransactionList.sort(Comparator.comparing(Transaction::getDate));
		return allTransactionList;
	}
	
	@PostMapping("/transaction")
	public Transaction createTransaction(@RequestBody Transaction transaction){
		System.out.println("transaction: " + transaction);
		return repository.save(transaction);
	}
	
//	@PostMapping("/transaction/payer/{payerid}/payee/{payeeid}/amount/{amount}")
//	public Transaction addTransaction(@PathVariable int payerid, @PathVariable int payeeid, @PathVariable int amount){
//		Transaction transaction = new Transaction();
//		Date date = new Date();
//		
//		transaction.setPayerid(payerid);
//		transaction.setPayeeid(payeeid);
//		transaction.setAmount(amount);
//		transaction.setDate(date);
//		
//		return repository.saveAndFlush(transaction);
//	}
	
}
