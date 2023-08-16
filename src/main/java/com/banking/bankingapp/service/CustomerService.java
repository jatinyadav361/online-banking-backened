package com.banking.bankingapp.service;

import java.util.List;

import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerLogin;

public interface CustomerService {
	
	String customerLogin(CustomerLogin loginData);
	String registerCustomer(Customer customer);
	List<Long> fetchAllAccounts(String username);

}
