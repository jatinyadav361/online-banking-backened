package com.banking.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.bankingapp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

}
