package com.ubp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubp.model.Transaction;
import com.ubp.service.TransactionService;

@CrossOrigin()
@RestController
@RequestMapping("transaction")
public class TransactionController {
	
	TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping("new-transaction")
	public String newTransaction(@RequestBody Transaction transaction) {
		return transactionService.newTransaction(transaction);
	}
	
	@GetMapping("get-all-transactions")
	public List<Transaction> getAllTransactions(@PathVariable long customerId){
		return transactionService.getAllTransactions(customerId);
	}
}

