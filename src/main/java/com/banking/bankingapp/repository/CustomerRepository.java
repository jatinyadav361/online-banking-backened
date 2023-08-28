package com.banking.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.bankingapp.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
	@Modifying
	@Query("update Customer c set c.locked = CASE c.locked when true then false else true end where c.username=?1")
	public int toggleLockedStatus(String username);
	
	@Modifying
	@Query("update Customer c set c.active = CASE c.active when true then false else true end where c.username=?1")
	public int toggleActiveStatus(String username);
	
	@Modifying
	@Query("update Customer c set c.admin = CASE c.admin when true then false else true end where c.username=?1")
	public int toggleAdminStatus(String username);
}
