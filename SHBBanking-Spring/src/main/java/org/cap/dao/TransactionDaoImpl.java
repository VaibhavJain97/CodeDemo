package org.cap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.cap.model.Account;
import org.cap.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//this table interacts with transactions table of DB
@Repository("transactionDao")
@Transactional
public class TransactionDaoImpl implements ITransactionDao	{
	

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	IAccountDao accountDao=new AccountDao();
	
	//add new transaction to DB
	@Override
	public boolean createTransaction(Transaction transaction) {
		
		em.persist(transaction);
		return true;
	}
	
	//retrieve all transactions for given customer
	@Override
	public List<Transaction> getTransactionsForCustomer(int customerId, LocalDate fromDate, LocalDate toDate)	{
		
		List<Account> accounts=new ArrayList<>();
		accounts=accountDao.getAccountsForCustomer(customerId);
		List<Transaction> transactions=new ArrayList<>();
		
		for(Account account:accounts)	{
			
			List<Transaction> tr=em.createQuery("from transactions where fromAccount="+account.getAccountNumber()+
					" or toAccount="+account.getAccountNumber()).getResultList();
			for(Transaction t:tr)	{
				if((t.getTransactionDate().isAfter(fromDate) && t.getTransactionDate().isBefore(toDate)) || (toDate.equals(LocalDate.now())))
					transactions.add(t);
			}
		}
		
		return transactions;
	}
	
	//get current balance for all accounts of given customer
	@Override
	public Map<Account, Double> getCurrentBalance(int customerId)	{
		
		List<Account> accounts=new ArrayList<>();
		accounts=accountDao.getAccountsForCustomer(customerId);
		List<Transaction> transactions=new ArrayList<>();
		Map<Account, Double> currentBalanceData=new HashMap<>();
		
		for(Account account:accounts)	{
			
			double openingBal=account.getOpeningBalance();
			double currentBal=openingBal;
			
			transactions=em.createQuery("from transactions where fromAccount="+account.getAccountNumber()+
					" or toAccount="+account.getAccountNumber()).getResultList();
			for(Transaction transaction:transactions)	{
					
					double amt =transaction.getAmount();
					//Calculating current balance
					if(transaction.getFromAccount()==account.getAccountNumber())
						currentBal-=amt;
					else if(transaction.getToAccount()==account.getAccountNumber())
						currentBal+=amt;
					
				}
	
			currentBalanceData.put(account, currentBal);
		}
		
		return currentBalanceData;
		
	}


}
