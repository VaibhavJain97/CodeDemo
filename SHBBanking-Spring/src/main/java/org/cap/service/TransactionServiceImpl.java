package org.cap.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.cap.dao.ITransactionDao;
import org.cap.model.Account;
import org.cap.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	ITransactionDao transactionDao;
	
	@Override
	public boolean createTransaction(Transaction transaction) {
		return transactionDao.createTransaction(transaction);
	}

	@Override
	public List<Transaction> getTransactionsForCustomer(int customerId, LocalDate fromDate, LocalDate toDate) {
		return transactionDao.getTransactionsForCustomer(customerId, fromDate, toDate);
	}

	@Override
	public Map<Account, Double> getCurrentBalance(int customerId) {
		
		return transactionDao.getCurrentBalance(customerId);
	}

}
