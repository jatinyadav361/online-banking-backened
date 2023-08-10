package com.banking.bankingapp.service;

import java.util.List;

import com.banking.bankingapp.model.Account;

public interface AccountService {
	Account createAccount(Account account);
	
	List<Account> fetchAllAccounts();
	
	Account updateAccount(Account account, String accountNo);
	
	void deleteAccount(String accountNo);
}
