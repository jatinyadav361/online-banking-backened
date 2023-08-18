package com.banking.bankingapp.service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.bankingapp.model.Account;
import com.banking.bankingapp.model.Transaction;
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
	public String withdrawlProcess(Transaction transaction, Long reciever , Long sender) {
		transaction.setDate(ZonedDateTime.now());
		Optional<Account> acc2 = accountRepo.findById(reciever);
		if(!acc2.isPresent()) {
			return "Reciever account invalid";
		}
		transaction.setRecieverAccount(acc2.get());
		Optional<Account> acc = accountRepo.findById(sender);
		if(!acc.isPresent()) {
			return "Sender account invalid";
		}
		Account account  = acc.get();
		transaction.setSenderAccount(account);
		double balance = account.getBalance();
		if(balance-transaction.gettAmount() < 1000) {
			return "Insufficient balance";
		}
		else {
			int rowEffected = accountRepo.updateBalanceSender(transaction.gettAmount(), sender);
			if(rowEffected > 0) {
				int rowEffected2 = accountRepo.updateBalanceReciever(transaction.gettAmount(), reciever);
				if(rowEffected2 > 0) {
					transaction.setInstBalance(balance-transaction.gettAmount());
					transactionRepository.save(transaction);
					return "Withdrawl process successful";
				}
				else {
					return "No transaction happened";
				}
			}
			else {
				return "No transaction happened";
			}
		}
	}

	@Override
	@Transactional
	public String selfCashWithdrawl(Transaction transaction, Long sender) {
		transaction.setDate(ZonedDateTime.now());
		Optional<Account> acc = accountRepo.findById(sender);
		if(!acc.isPresent()) {
			return "Sender account invalid";
		}
		Account account  = acc.get();
		transaction.setSenderAccount(account);
		double balance = account.getBalance();
		if(balance-transaction.gettAmount() < 1000) {
			return "Insufficient balance";
		}
		else {
			int rowEffected = accountRepo.updateBalanceSender(transaction.gettAmount(), sender);
			if(rowEffected > 0) {
				transaction.setInstBalance(balance-transaction.gettAmount());
				transactionRepository.save(transaction);
				return "Withdrawl process successful";
			}
			else {
				return "No transaction happened";
			}
		}
	}

	@Override
	public List<Long> fetchAccountSummary(long accountNo) {
		return transactionRepository.fetchAccountSummary(accountNo);
	}
}
