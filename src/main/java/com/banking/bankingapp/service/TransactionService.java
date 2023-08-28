package com.banking.bankingapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.banking.bankingapp.model.Transaction;
import com.banking.bankingapp.model.TransactionFetch;

public interface TransactionService {
	
	ResponseEntity<String> withdrawlProcess(Transaction transaction, Long reciever , Long sender);
	
	ResponseEntity<String> selfCashWithdrawl(Transaction transaction, Long sender);
	
	ResponseEntity<String> selfCashDeposit(Transaction transaction, Long sender);
	
	List<TransactionFetch> fetchAccountSummary(long accountNo);
	
	List<TransactionFetch> fetchAllTransactions(long accountNo);
	
	List<TransactionFetch> fetchAccountStatement(long accountNo, Date startDate, Date endDate);
}
