package com.banking.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.bankingapp.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
}
