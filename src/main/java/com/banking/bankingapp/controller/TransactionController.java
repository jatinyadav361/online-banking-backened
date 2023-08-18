package com.banking.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// http://localhost:8080/accountSummary?accountNo=1000000000
	@GetMapping("accountSummary")
	public List<Long> fetchAccountSummary(@RequestParam("accountNo") Long sender) {
		return transactionService.fetchAccountSummary(sender);
	}
	
	// we will  get sender account as params
	// http://localhost:8080/selfWithdrawl?sender=1000000000
	@PostMapping("selfWithdrawl")
	public String selfWithdrawlCash(@Valid @RequestBody Transaction transaction, @RequestParam("sender") Long sender) {
		return transactionService.selfCashWithdrawl(transaction, sender);
	}
	
	// we will  get sender and reciever account as params
	// http://localhost:8080/transaction?sender=1000000000&reciever=1000000088
	@PostMapping("transaction")
	public String withdrawlProcess(@Valid @RequestBody Transaction transaction, @RequestParam("reciever") Long reciever, @RequestParam("sender") Long sender) {
		return transactionService.withdrawlProcess(transaction,reciever , sender);
	}
	
}
