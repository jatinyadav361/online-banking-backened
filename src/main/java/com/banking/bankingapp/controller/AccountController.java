package com.banking.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.service.AccountService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	// username is passed as parameter /accounts?username=admin
	// creating a new account
	@PostMapping("accounts")
	public ResponseEntity<String> createAccount(@Valid @RequestBody Account account, @RequestParam("username") String username) {
		return accountService.createAccount(account, username);
	}
	
	// fetching a account using accountNo
	@GetMapping("accounts/{accNo}")
	public ResponseEntity<Double> fetchBalance(@PathVariable("accNo") long accNo) {
		return accountService.fetchBalance(accNo);
	}
	
}
