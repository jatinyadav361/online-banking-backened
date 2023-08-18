package com.banking.bankingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.bankingapp.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query("select t.transactionId from Transaction t where t.senderAccount.accountNo=?1 or (t.recieverAccount != null and t.recieverAccount.accountNo=?1)")
	
	public List<Long> fetchAccountSummary(long accountId);
	
}
