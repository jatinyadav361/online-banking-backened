package com.banking.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.bankingapp.model.AccountFetch;
import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerDTO;
import com.banking.bankingapp.model.CustomerLogin;
import com.banking.bankingapp.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("http://localhost:3000")

public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	// // http://localhost:8080/register
	@PostMapping("register")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
	}
	
	// http://localhost:8080/login
	@PostMapping("login")
	public ResponseEntity<String> loginCustomer(@Valid @RequestBody CustomerLogin customer) {
		return customerService.customerLogin(customer);
	}
	
	// fetch all accounts of a user
	// http://localhost:8080/fetchAccounts/{username}
	@GetMapping("fetchAccounts/{username}")
	public List<AccountFetch> fetchAllAccounts(@PathVariable("username") String username) {
		return customerService.fetchAllAccounts(username);
	}
	
	// fetch  a user 
	// http://localhost:8080/customer/{username}
	@GetMapping("customer/{username}")
	public CustomerDTO fetchUser(@PathVariable("username") String username) {
		return customerService.fetchUser(username);
	}
	
	@GetMapping("getAllUsers")
	public List<CustomerDTO> getAllUsers() {
		return customerService.fetchAllUsers();
	}
	
	@PutMapping("user/toggleLock/{username}")
	public ResponseEntity<String> toggleLockedStatus(@PathVariable("username") String username) {
		return customerService.toggleLockedStatus(username);
	}
	
	@PutMapping("user/toggleActive/{username}")
	public ResponseEntity<String> toggleActiveStatus(@PathVariable("username") String username) {
		return customerService.toggleActivatedStatus(username);
	}
	
	@PutMapping("user/toggleAdmin/{username}")
	public ResponseEntity<String> toggleAdminStatus(@PathVariable("username") String username) {
		return customerService.toggleAdminStatus(username);
	}

}
