package com.banking.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.Transaction;
import com.banking.bankingapp.service.CustomerService;
import com.banking.bankingapp.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	// we will  get sender and reciever account as params
	@PostMapping("transaction")
	public String withdrawlProcess(@Valid @RequestBody Transaction transaction, @RequestParam("reciever") Long reciever, @RequestParam("sender") Long sender) {
		return transactionService.withdrawlProcess(transaction,reciever , sender);
	}
	
}
