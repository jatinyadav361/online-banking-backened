package com.banking.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	@PostMapping("accounts")
	public String createAccount(@Valid @RequestBody Account account, @RequestParam("username") String username) {
		return accountService.createAccount(account, username);
	}
	
	@GetMapping("accounts/{accNo}")
	public Account fetchAccount(@PathVariable("accNo") long accNo) {
		return accountService.fetchAccount(accNo);
	}
//	
//	@PutMapping("accounts/{accNo}")
//	public Account updateAccount(@RequestBody Account account, @PathVariable("accNo") long accNo) {
//		return accountService.updateAccount(account, accNo);
//	}
	
//	@DeleteMapping("accounts/{accNo}")
//	public String deleteAccount(@PathVariable("accNo") long accNo) {
//		accountService.deleteAccount(accNo);
//		return "Account Deleted Successfully";
//	}
	
}
