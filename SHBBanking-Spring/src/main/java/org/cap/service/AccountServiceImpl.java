package org.cap.service;

import java.util.List;

import org.cap.dao.IAccountDao;
import org.cap.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccountDao accountDao;
	
	@Override
	public boolean createAccount(Account account) {
		return accountDao.createAccount(account);
	}

	@Override
	public List<Account> getAccountsForCustomer(int customerId) {
		return accountDao.getAccountsForCustomer(customerId);
	}

	@Override
	public List<Account> getAccountsExceptCustomer(int customerId) {
		return accountDao.getAccountsExceptCustomer(customerId);
	}

}
