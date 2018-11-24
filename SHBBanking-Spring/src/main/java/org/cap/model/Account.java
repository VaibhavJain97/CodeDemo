package org.cap.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(name="seq", initialValue=10000, allocationSize=100)
@Entity
@Table(name="accounts")
public class Account {
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerId")
	private RegisterBean customer;
	@Id
	@Column(name="accountNo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private long accountNumber;
	private String accountType;
	private LocalDate openingDate;
	private double openingBalance;
	private String description;
	
	
	public Account() {
		
	}


	public RegisterBean getCustomer() {
		return customer;
	}


	public void setCustomer(RegisterBean customer) {
		this.customer = customer;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public LocalDate getOpeningDate() {
		return openingDate;
	}


	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}


	public double getOpeningBalance() {
		return openingBalance;
	}


	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Account [customer=" + customer + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", openingDate=" + openingDate + ", openingBalance=" + openingBalance + ", description=" + description
				+ "]";
	}


	public Account(RegisterBean customer, long accountNumber, String accountType, LocalDate openingDate,
			double openingBalance, String description) {
		super();
		this.customer = customer;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.openingBalance = openingBalance;
		this.description = description;
	}
	

	
	

}
