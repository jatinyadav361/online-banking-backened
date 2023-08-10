package com.banking.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("accounts")
	public Account createAccount(@Valid @RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	@GetMapping("accounts")
	public List<Account> fetchAllAccounts() {
		return accountService.fetchAllAccounts();
	}
	
	@PutMapping("accounts/{accNo}")
	public Account updateAccount(@RequestBody Account account, @PathVariable("accNo") String accNo) {
		return accountService.updateAccount(account, accNo);
	}
	
	@DeleteMapping("accounts/{accNo}")
	public String deleteAccount(@PathVariable("accNo") String accNo) {
		accountService.deleteAccount(accNo);
		return "Account Deleted Successfully";
	}
	
}
