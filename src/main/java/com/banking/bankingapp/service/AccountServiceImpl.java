package com.banking.bankingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.repository.AccountRepository;
import com.banking.bankingapp.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public ResponseEntity<String> createAccount(Account account, String username) {
		Optional<Customer> cust = customerRepository.findById(username);
		if(cust.isPresent()) {
			account.setCustomer(cust.get());
			account.setBalance(2000.00);
			account.setIfsc("SBIN0011870");
			accountRepository.save(account);
			return ResponseEntity.status(200).body("Account created successfully with account no " + account.getAccountNo());
		}
		else {
			return ResponseEntity.status(404).body("Username does not exist");
		}
	}

	@Override
	public Account fetchAccount(long accId) {
		Optional<Account> acc = accountRepository.findById(accId);
		return acc.get();
	}

	@Override
	public Account updateAccount(Account account, long accountNo) {
		// only allows updating the ifsc code
		Optional<Account> prevAccount = accountRepository.findById(accountNo);
		if(prevAccount.isPresent()) {
			if(!account.getIfsc().isEmpty()) {
				prevAccount.get().setIfsc(account.getIfsc());
			}
			return accountRepository.save(prevAccount.get());
		}
		else {
			return accountRepository.save(account);
		}
	}

	@Override
	public void deleteAccount(long accountNo) {
		accountRepository.deleteById(accountNo);	
	}
	
}
