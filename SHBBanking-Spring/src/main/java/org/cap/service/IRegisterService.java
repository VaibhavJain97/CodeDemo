package org.cap.service;

import java.util.List;

import org.cap.model.RegisterBean;

public interface IRegisterService {

	public boolean registerDetails(RegisterBean registerBean);
	public List<RegisterBean> getAllRegistrations();
	public void deleteRegistration(long customerId);
	public RegisterBean findRegistration(long customerId);
	public void updateRegistration(RegisterBean registerBean);
}
