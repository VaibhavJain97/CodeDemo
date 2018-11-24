package org.cap.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.cap.model.Account;
import org.cap.model.Transaction;



public interface ITransactionDao {

	public boolean createTransaction(Transaction transaction);
	public List<Transaction> getTransactionsForCustomer(int customerId, LocalDate fromDate, LocalDate toDate);
	public Map<Account, Double> getCurrentBalance(int customerId);
}
