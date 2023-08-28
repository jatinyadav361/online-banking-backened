package com.banking.bankingapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
			customer.setLocked(false);
			customer.setActive(false);
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
	public boolean getUserActiveStatus(String username) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public ResponseEntity<String> activateUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<String> lockUser(String username) {
		Optional<Customer> cust = customerRepository.findById(username);
		if(cust.isPresent()) {
//			boolean status = cust.get().isLocked();
//			cust.get().setLocked(!status);
//			customerRepository.save(cust.get());
			return ResponseEntity.status(200) .body("User Status" + cust.get().isLocked());
		}
		else {
			return ResponseEntity.status(404).body("User does not exist!");
		}
	}


	@Override
	public boolean getUserLockStatus(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
