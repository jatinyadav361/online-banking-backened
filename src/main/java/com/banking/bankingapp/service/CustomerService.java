package com.banking.bankingapp.service;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.model.AccountFetch;
import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerLogin;

public interface CustomerService {
	
	ResponseEntity<String> customerLogin(CustomerLogin loginData);
	
	ResponseEntity<String> registerCustomer(Customer customer);
	
	List<AccountFetch> fetchAllAccounts(String username);

}
