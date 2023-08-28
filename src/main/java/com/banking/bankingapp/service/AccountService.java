package com.banking.bankingapp.service;

import org.springframework.http.ResponseEntity;

import com.banking.bankingapp.model.Account;

public interface AccountService {
	ResponseEntity<String> createAccount(Account account, String username);
	
	ResponseEntity<Double> fetchBalance(long accId);
	
}
