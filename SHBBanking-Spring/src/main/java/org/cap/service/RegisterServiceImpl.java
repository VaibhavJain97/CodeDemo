package org.cap.service;

import java.util.List;

import org.cap.dao.IRegisterDao;
import org.cap.model.RegisterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("registerService")
public class RegisterServiceImpl implements IRegisterService {

	@Autowired
	private IRegisterDao registerDao;
	
	@Override
	public boolean registerDetails(RegisterBean registerBean) {
		return registerDao.registerDetails(registerBean);
	}

	@Override
	public List<RegisterBean> getAllRegistrations() {
		return registerDao.getAllRegistrations();
	}
	
	public void deleteRegistration(long customerId)	{
		registerDao.deleteRegistration(customerId);
	}

	public RegisterBean findRegistration(long customerId)	{
		return registerDao.findRegistration(customerId);
	}
	
	public void updateRegistration(RegisterBean registerBean)	{
		registerDao.updateRegistration(registerBean);
	}
	
}
