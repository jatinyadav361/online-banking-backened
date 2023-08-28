package com.banking.bankingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.model.AccountFetch;
import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerDTO;
import com.banking.bankingapp.model.CustomerLogin;
import com.banking.bankingapp.repository.AccountRepository;
import com.banking.bankingapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public ResponseEntity<String> customerLogin(CustomerLogin loginData) {
		Optional<Customer> customerData = customerRepository.findById(loginData.getUsername());
		Customer c = customerData.get();
		if(customerData.isPresent()) {
			if(customerData.get().isActive() == true && customerData.get().isLocked() == false) {
				if(loginData.isAdmin()) {
					if(customerData.get().isAdmin() == true) {
						if(customerData.get().getPassword().equals(loginData.getPassword())) {
							c.setIncorrectPassAttempt(0);
							customerRepository.save(c);
							return ResponseEntity.status(200).body("true");
						}
						else {
							if(customerData.get().getIncorrectPassAttempt() < 2) {
								c.setIncorrectPassAttempt(c.getIncorrectPassAttempt()+1);
								customerRepository.save(c);
								return ResponseEntity.status(404).body("Incorrect Password, only ".concat(Integer.toString(3-c.getIncorrectPassAttempt())).concat(" out of 3 attempts remaining"));
							}
							else {
								c.setIncorrectPassAttempt(0);
								c.setLocked(true);
								customerRepository.save(c);
								return ResponseEntity.status(404).body("Incorrect Password, Your account has been locked due to 3 incorrect attempts");
							}
						}
					}
					else {
						return ResponseEntity.status(404).body("You don't have admin access");
					}
				}
				else {
					if(customerData.get().getPassword().equals(loginData.getPassword())) {
						c.setIncorrectPassAttempt(0);
						customerRepository.save(c);
						return ResponseEntity.status(200).body("false");
					}
					else {
						if(customerData.get().getIncorrectPassAttempt() < 2) {
							c.setIncorrectPassAttempt(c.getIncorrectPassAttempt()+1);
							customerRepository.save(c);
							return ResponseEntity.status(404).body("Incorrect Password, only ".concat(Integer.toString(3-c.getIncorrectPassAttempt())).concat(" out of 3 attempts remaining"));
						}
						else {
							c.setIncorrectPassAttempt(0);
							c.setLocked(true);
							customerRepository.save(c);
							return ResponseEntity.status(404).body("Incorrect Password, Your account has been locked due to 3 incorrect attempts");
						}
					}
				}
			}
			else {
				return ResponseEntity.status(404).body("Your account is locked or inactive. Please contact bank admin");
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
			customer.setLocked(false);
			customer.setActive(false);
			customer.setAdmin(false);
			customer.setIncorrectPassAttempt(0);
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

	private CustomerDTO convertToDto(Customer cust) {
		CustomerDTO custDto = modelMapper.map(cust, CustomerDTO.class);
	    return custDto;
	}

	
	@Override
	public List<CustomerDTO> fetchAllUsers() {
		List<Customer> cust = customerRepository.findAll();
		return cust.stream()
		          .map(this::convertToDto)
		          .collect(Collectors.toList());
	}


	@Override
	public CustomerDTO fetchUser(String username) {
		Optional<Customer> cust = customerRepository.findById(username);
		if(cust.isPresent()) {
			return convertToDto(cust.get());
		}
		else {
			return null;
		}
	}


	@Override
	@Transactional
	public ResponseEntity<String> toggleActivatedStatus(String username) {
		Optional<Customer> cust = customerRepository.findById(username);
		if(cust.isPresent()) {
			customerRepository.toggleActiveStatus(username);
			return ResponseEntity.status(200) .body("User active Status toggled");
		}
		else {
			return ResponseEntity.status(404).body("User does not exist!");
		}
	}


	@Override
	@Transactional
	public ResponseEntity<String> toggleLockedStatus(String username) {
		Optional<Customer> cust = customerRepository.findById(username);
		if(cust.isPresent()) {
			customerRepository.toggleLockedStatus(username);
			return ResponseEntity.status(200) .body("User locked Status toggled");
		}
		else {
			return ResponseEntity.status(404).body("User does not exist!");
		}
	}


	@Override
	@Transactional
	public ResponseEntity<String> toggleAdminStatus(String username) {
		Optional<Customer> cust = customerRepository.findById(username);
		if(cust.isPresent()) {
			customerRepository.toggleAdminStatus(username);
			return ResponseEntity.status(200) .body("User admin Status toggled");
		}
		else {
			return ResponseEntity.status(404).body("User does not exist!");
		}
	}
	
	
}
