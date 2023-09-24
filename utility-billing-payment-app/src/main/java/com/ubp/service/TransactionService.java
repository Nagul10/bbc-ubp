package com.ubp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubp.dao.TransactionDao;
import com.ubp.model.Transaction;

@Service
public class TransactionService {
	TransactionDao transactionDao;
	
	@Autowired
	public TransactionService(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	public String newTransaction(Transaction transaction) {
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionStatus("Done");
		transactionDao.newTransaction(transaction);
		return "success";
	}
	public List<Transaction> getAllTransactions(long customerId) {
		
		return transactionDao.getAllTransactions(customerId);
	}

}
