package com.banking.bankingapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.model.AccountFetch;
import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerLogin;
import com.banking.bankingapp.repository.AccountRepository;
import com.banking.bankingapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public ResponseEntity<String> customerLogin(CustomerLogin loginData) {
		Optional<Customer> customerData = customerRepository.findById(loginData.getUsername());
		if(customerData.isPresent()) {
			if(customerData.get().getPassword().equals(loginData.getPassword())) {
				return ResponseEntity.status(200) .body("Login Successful");
			}
			else {
				return ResponseEntity.status(404).body("Incorrect Password");
			}
		}
		else {
			return ResponseEntity.status(404).body("User does not exist!");
		}
	}

	
	@Override
	public ResponseEntity<String> registerCustomer(Customer customer) {
		Optional<Customer> customerData = customerRepository.findById(customer.getUsername());
		if(customerData.isPresent()) {
			return ResponseEntity.status(404).body("User already exists! Choose a different username");
		}
		else {
			customerRepository.save(customer);
			return ResponseEntity.status(200).body("User created");
		}
	}

	
	@Override
	public List<AccountFetch> fetchAllAccounts(String username) {
		List<Long> accIds=  accountRepository.fetchAllAccounts(username);
		List<AccountFetch> accounts = new ArrayList<AccountFetch>();
		for(int i=0; i<accIds.size();i++) {
			Optional<Account> a = accountRepository.findById(accIds.get(i));
			Account ac = a.get();
			AccountFetch acFetch = new AccountFetch();
			acFetch.setAccountNo(ac.getAccountNo());
			acFetch.setAccountType(ac.getAccountType());
			acFetch.setBalance(ac.getBalance());
			acFetch.setIfsc(ac.getIfsc());
			accounts.add(acFetch);
		}
		
		return accounts;
	}
	
	
	
}
