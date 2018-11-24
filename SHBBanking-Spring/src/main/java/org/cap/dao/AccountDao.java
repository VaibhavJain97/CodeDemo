package org.cap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.cap.model.Account;
import org.cap.model.AccountType;
import org.springframework.stereotype.Repository;



//this class interacts with accounts table of DB
@Repository("accountDao")
@Transactional
public class AccountDao implements IAccountDao	{

	
	@PersistenceContext
	private EntityManager em;
	
	//create new account for customer
	@Override
	public boolean createAccount(Account account) {
		
		em.persist(account);
		
		return true;
	}
	
	//get all accounts for one customer
	@Override
	public List<Account> getAccountsForCustomer(int customerId)	{
		
		return (List<Account>) em.createQuery("from accounts where customerId="+customerId).getResultList();
	}
	
	//get all accounts except those of mentioned customer
	@Override
	public List<Account> getAccountsExceptCustomer(int customerId)	{
		return (List<Account>) em.createQuery("from accounts where customerId<>"+customerId).getResultList();
	}
	
	
}
