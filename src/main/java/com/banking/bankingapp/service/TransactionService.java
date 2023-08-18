package com.banking.bankingapp.service;

import java.util.List;

import com.banking.bankingapp.model.Transaction;

public interface TransactionService {
	
	String withdrawlProcess(Transaction transaction, Long reciever , Long sender);
	
	String selfCashWithdrawl(Transaction transaction, Long sender);
	
	List<Long> fetchAccountSummary(long accountNo);
	
}
