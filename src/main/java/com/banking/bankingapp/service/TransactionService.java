package com.banking.bankingapp.service;

import com.banking.bankingapp.model.Transaction;

public interface TransactionService {
	
	String withdrawlProcess(Transaction transaction, Long reciever , Long sender);
	
}
