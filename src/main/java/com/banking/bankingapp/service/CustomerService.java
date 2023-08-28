package com.banking.bankingapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.banking.bankingapp.model.AccountFetch;
import com.banking.bankingapp.model.Customer;
import com.banking.bankingapp.model.CustomerDTO;
import com.banking.bankingapp.model.CustomerLogin;

public interface CustomerService {
	
	ResponseEntity<String> customerLogin(CustomerLogin loginData);
	
	ResponseEntity<String> registerCustomer(Customer customer);
	
	List<AccountFetch> fetchAllAccounts(String username);
	
	List<CustomerDTO> fetchAllUsers();
	
	CustomerDTO fetchUser(String username);
		
	ResponseEntity<String> toggleActivatedStatus(String username);
	
	ResponseEntity<String> toggleLockedStatus(String username);
	
	ResponseEntity<String> toggleAdminStatus(String username);
	
//	boolean getUserActiveStatus(String username);

//	boolean getUserLockStatus(String username);

}
