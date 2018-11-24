package org.cap.service;

import java.util.List;

import org.cap.model.Account;

public interface IAccountService {

	public boolean createAccount(Account account);
	public List<Account> getAccountsForCustomer(int customerId);
	public List<Account> getAccountsExceptCustomer(int customerId);
	
}
