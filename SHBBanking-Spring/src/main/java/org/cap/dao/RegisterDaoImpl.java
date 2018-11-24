package org.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.cap.model.RegisterBean;
import org.springframework.stereotype.Repository;

@Repository("registerDao")
@Transactional
public class RegisterDaoImpl implements IRegisterDao	{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public boolean registerDetails(RegisterBean registerBean) {
		em.persist(registerBean);
		return true;
	}

	@Override
	public List<RegisterBean> getAllRegistrations() {
		
		return (List<RegisterBean>) em.createQuery("from RegisterBean").getResultList();
		
	}

	@Override
	public void deleteRegistration(long customerId) {
		RegisterBean register=em.find(RegisterBean.class, customerId);
		em.remove(register);
	}
	
	@Override
	public RegisterBean findRegistration(long customerId) {
		RegisterBean register= em.find(RegisterBean.class, customerId);
		
		return register;
	}

	public void updateRegistration(RegisterBean registerBean)	{
		em.merge(registerBean);
	}
	
}
