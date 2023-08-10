package com.banking.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> fetchAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Account updateAccount(Account account, String accountNo) {
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
	public void deleteAccount(String accountNo) {
		accountRepository.deleteById(accountNo);	
	}
	
}
