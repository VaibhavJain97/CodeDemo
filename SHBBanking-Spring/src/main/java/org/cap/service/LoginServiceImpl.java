package org.cap.service;

import org.cap.dao.ILoginDao;
import org.cap.model.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginDao loginDao;
	
	@Override
	public LoginBean IsValidLogin(LoginBean loginBean) {
		return loginDao.isValidLogin(loginBean);
	}


}
