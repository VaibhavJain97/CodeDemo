package org.cap.dao;

import java.util.List;

import org.cap.model.Account;


public interface IAccountDao {

	public boolean createAccount(Account account);
	public List<Account> getAccountsForCustomer(int customerId);
	public List<Account> getAccountsExceptCustomer(int customerId);
}
