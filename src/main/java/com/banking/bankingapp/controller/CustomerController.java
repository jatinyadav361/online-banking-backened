package com.banking.bankingapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerLogin;
import com.banking.bankingapp.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")

public class CustomerController {


	@Autowired
	private CustomerService customerService;
	
	@PostMapping("register")
	public String createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
	}
	
	@PostMapping("login")
	public String loginCustomer(@Valid @RequestBody CustomerLogin customer) {
		return customerService.customerLogin(customer);
	}
	
	// fetch all accounts of a user
	@GetMapping("fetchAccounts/{username}")
	public List<Long> fetchAllAccounts(@PathVariable("username") String username) {
		return customerService.fetchAllAccounts(username);
	}
	

}
