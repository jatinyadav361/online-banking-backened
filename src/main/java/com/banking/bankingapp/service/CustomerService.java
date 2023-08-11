package com.banking.bankingapp.service;

import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerLogin;

public interface CustomerService {
	
	String customerLogin(CustomerLogin loginData);
	String registerCustomer(Customer customer);

}
