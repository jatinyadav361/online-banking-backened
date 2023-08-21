package com.banking.bankingapp.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.model.AccountFetch;
import com.banking.bankingapp.model.Transaction;
import com.banking.bankingapp.model.TransactionFetch;
import com.banking.bankingapp.repository.AccountRepository;
import com.banking.bankingapp.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepo;
	
	@Override
	@Transactional
	public ResponseEntity<String> withdrawlProcess(Transaction transaction, Long reciever , Long sender) {
		transaction.setTimestamp(ZonedDateTime.now());
		transaction.setDate(new Date());
		Optional<Account> acc2 = accountRepo.findById(reciever);
		if(!acc2.isPresent()) {
			return  ResponseEntity.status(404).body("Reciever account invalid");
		}
		transaction.setRecieverAccount(acc2.get());
		Optional<Account> acc = accountRepo.findById(sender);
		if(!acc.isPresent()) {
			return  ResponseEntity.status(404).body("Sender account invalid");
		}
		Account account  = acc.get();
		transaction.setSenderAccount(account);
		double balance = account.getBalance();
		if(balance-transaction.gettAmount() < 1000) {
			return  ResponseEntity.status(404).body("Insufficient balance");
		}
		else {
			int rowEffected = accountRepo.updateBalanceSender(transaction.gettAmount(), sender);
			if(rowEffected > 0) {
				int rowEffected2 = accountRepo.updateBalanceReciever(transaction.gettAmount(), reciever);
				if(rowEffected2 > 0) {
					transaction.setInstBalance(balance-transaction.gettAmount());
					transactionRepository.save(transaction);
					return  ResponseEntity.status(200).body("Withdrawl process successful");
				}
				else {
					return  ResponseEntity.status(404).body("No transaction happened");
				}
			}
			else {
				return  ResponseEntity.status(404).body("No transaction happened");
			}
		}
	}


	@Override
	@Transactional
	public ResponseEntity<String> selfCashWithdrawl(Transaction transaction, Long sender) {
		transaction.setTimestamp(ZonedDateTime.now());
		transaction.setDate(new Date());
		Optional<Account> acc = accountRepo.findById(sender);
		if(!acc.isPresent()) {
			return  ResponseEntity.status(404).body("Sender account invalid");
		}
		Account account  = acc.get();
		transaction.setSenderAccount(account);
		double balance = account.getBalance();
		if(balance-transaction.gettAmount() < 1000) {
			return  ResponseEntity.status(404).body("Insufficient balance");
		}
		else {
			int rowEffected = accountRepo.updateBalanceSender(transaction.gettAmount(), sender);
			if(rowEffected > 0) {
				transaction.setInstBalance(balance-transaction.gettAmount());
				transactionRepository.save(transaction);
				return  ResponseEntity.status(200).body("Withdrawl process successful");
			}
			else {
				return  ResponseEntity.status(404).body("No transaction happened");
			}
		}
	}

	@Override
	public List<TransactionFetch> fetchAccountSummary(long accountNo) {
		
		List<Long> transactionIds=  transactionRepository.fetchAccountSummary(accountNo);
	
		List<TransactionFetch> transactions = new ArrayList<TransactionFetch>();
		
		for(int i=0; i<transactionIds.size();i++) {
			Optional<Transaction> t = transactionRepository.findById(transactionIds.get(i));
			Transaction tc = t.get();
			
			TransactionFetch tFetch = new TransactionFetch();
			tFetch.setTransactionId(tc.getTransactionId());
			tFetch.setDate(tc.getDate());
			tFetch.setInstBalance(tc.getInstBalance());
			tFetch.setRecieverAccountId(tc.getRecieverAccount().getAccountNo());
			tFetch.setSenderAccountId(tc.getSenderAccount().getAccountNo());
			tFetch.settAmount(tc.gettAmount());
			tFetch.settMode(tc.gettMode());
			tFetch.settType("");
			
			transactions.add(tFetch);
		}
		
		return transactions;
	}

	
	@Override
	public List<TransactionFetch> fetchAccountStatement(long accountNo, Date startDate, Date endDate) {
		List<Long> transactionIds=  transactionRepository.fetchAccountStatement(accountNo, startDate, endDate);
		
		List<TransactionFetch> transactions = new ArrayList<TransactionFetch>();
		
		for(int i=0; i<transactionIds.size();i++) {
			Optional<Transaction> t = transactionRepository.findById(transactionIds.get(i));
			Transaction tc = t.get();
			
			TransactionFetch tFetch = new TransactionFetch();
			tFetch.setTransactionId(tc.getTransactionId());
			tFetch.setDate(tc.getDate());
			tFetch.setInstBalance(tc.getInstBalance());
			tFetch.setRecieverAccountId(tc.getRecieverAccount().getAccountNo());
			tFetch.setSenderAccountId(tc.getSenderAccount().getAccountNo());
			tFetch.settAmount(tc.gettAmount());
			tFetch.settMode(tc.gettMode());
			tFetch.settType("");
			
			transactions.add(tFetch);
		}
		
		return transactions;
	}
	
	
}
