package com.banking.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String customerLogin(CustomerLogin loginData) {
		Optional<Customer> customerData = customerRepository.findById(loginData.getUsername());
		if(customerData.isPresent()) {
			if(customerData.get().getPassword().equals(loginData.getPassword())) {
				return "Login Successful";
			}
			else {
				return "Incorrect Password";
			}
		}
		else {
			return "User does not exist!";
		}
	}

	@Override
	public String registerCustomer(Customer customer) {
		Optional<Customer> customerData = customerRepository.findById(customer.getUsername());
		if(customerData.isPresent()) {
			return "User already exists! Choose a different username";
		}
		else {
			customerRepository.save(customer);
			return "User created";
		}
	}

	@Override
	public List<Long> fetchAllAccounts(String username) {
		return accountRepository.fetchAllAccounts(username);
	}
	
	
	
}
