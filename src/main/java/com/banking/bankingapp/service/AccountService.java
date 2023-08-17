package com.banking.bankingapp.service;

import java.util.List;

import com.banking.bankingapp.model.Account;

public interface AccountService {
	String createAccount(Account account, String username);
	
	Account fetchAccount(long accId);
	
	Account updateAccount(Account account, long accountNo);
	
	void deleteAccount(long accountNo);
}
