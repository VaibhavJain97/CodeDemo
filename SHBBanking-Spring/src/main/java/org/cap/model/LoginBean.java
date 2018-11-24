package org.cap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class LoginBean {
	
	@Id
	@GeneratedValue
	@Column(name="customerId")
	private int userId;
	
	@Column(name="emailID")
	private String userName;
	@Column(name="customerPwd")
	private String userPassword;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	public LoginBean(int userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "LoginBean [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	public LoginBean()	{}
	
	
	

}
