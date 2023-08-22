package com.banking.bankingapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.bankingapp.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query("select t.transactionId from Transaction t where t.senderAccount.accountNo=?1 or (t.recieverAccount != null and t.recieverAccount.accountNo=?1) order by t.timestamp desc limit 10")
	public List<Long> fetchAccountSummary(long accountId);
	
	@Query("select t.transactionId from Transaction t where (t.senderAccount.accountNo=?1 or (t.recieverAccount != null and t.recieverAccount.accountNo=?1)) and (t.date <=?3 and t.date >=?2) order by t.timestamp desc")
	public List<Long> fetchAccountStatement(long accountId, Date startDate, Date endDate);
	
}