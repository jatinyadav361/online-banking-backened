package com.banking.bankingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.bankingapp.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("select a.accountNo from Account a where a.customer.username=?1")
	public List<Long> fetchAllAccounts(String username);
	
	@Modifying
	@Query("update Account account set account.balance=account.balance-?1 where account.accountNo=?2")
	public int updateBalanceSender(double amount, long accountNo);
	
	@Modifying
	@Query("update Account account set account.balance=account.balance+?1 where account.accountNo=?2")
	public int updateBalanceReciever(double amount, long accountNo);
	
}
