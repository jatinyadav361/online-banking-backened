package com.banking.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String createAccount(Account account, String username) {
		Optional<Customer> cust = customerRepository.findById(username);
		if(cust.isPresent()) {
			account.setCustomer(cust.get());
			accountRepository.save(account);
			return "Account created successfully with account no " + account.getAccountNo();
		}
		else {
			return "Username does not exist";
		}
	}

	@Override
	public List<Account> fetchAllAccounts() {
		return (List<Account>) accountRepository.findAll();
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
