package org.cap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.cap.model.LoginBean;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
@Transactional
public class LoginDaoImpl implements ILoginDao	{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public LoginBean isValidLogin(LoginBean loginBean) {
		String sql="from LoginBean where emailID=:userName and customerPwd=:userPwd";
		Query query= em.createQuery(sql);
		query.setParameter("userName", loginBean.getUserName());
		query.setParameter("userPwd", loginBean.getUserPassword());
		
		List<LoginBean> list= query.getResultList();
		LoginBean loginData=list.get(0);
		return loginData;
	}
	
	

}
