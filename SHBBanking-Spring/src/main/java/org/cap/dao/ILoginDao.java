package org.cap.dao;

import org.cap.model.LoginBean;

public interface ILoginDao {
	
	public LoginBean isValidLogin(LoginBean loginBean);

}
