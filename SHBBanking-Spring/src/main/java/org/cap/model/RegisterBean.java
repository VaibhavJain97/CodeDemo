package org.cap.model;

//import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="customer")
@SecondaryTable(name="address")
public class RegisterBean {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long customerId;
	
	@NotEmpty(message="*First Name cannot be empty!")
	private String firstName;
	@NotEmpty(message="*Last Name cannot be empty!")
	private String lastName;
	
	@Column(table="address")
	private String addressLine1;
	@Column(table="address")
	private String addressLine2;
	@Column(table="address")
	private String city;
	@Column(table="address")
	private String state;
	@Column(table="address", name="pinCode")
	@Length(min=6,max=6,message="*Enter a valid 6 digit pincode.")
	private String pincode;
	
	@Length(min=10,max=10,message="*Enter a 10 digit mobile number.")
	@Column(name="mobileNo")
	private String mobileNumber;
	
	private String gender;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past(message="*Enter date of birth before current date!")
	private Date dateOfBirth;
	
	@Range(min=2000, max=5000, message="*Fees should be between Rs.2000 and Rs.5000.")
	private double registrationFees;
	
	@Email(message="*Please provide a valid Email ID!")
	@NotEmpty(message="*Please enter Email ID!")
	private String emailId;
	
	@Column(name="customerPwd")
	@Length(min=6,max=10,message="*Password length should be between 6 to 10 characters.")
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Transient
	@OneToMany(mappedBy="customer", targetEntity=Account.class,cascade=CascadeType.ALL)
	private List<Account> accounts;

    
	@Override
	public String toString() {
		return "RegisterBean [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", mobileNumber=" + mobileNumber + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", registrationFees=" + registrationFees + ", emailId=" + emailId
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", accounts=" + accounts + "]";
	}


	public RegisterBean(long customerId, String firstName, String lastName, String addressLine1, String addressLine2,
			String city, String state, String pincode, String mobileNumber, String gender, Date dateOfBirth,
			double registrationFees, String emailId, String password, String confirmPassword, List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.registrationFees = registrationFees;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.accounts = accounts;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public double getRegistrationFees() {
		return registrationFees;
	}


	public void setRegistrationFees(double registrationFees) {
		this.registrationFees = registrationFees;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	public RegisterBean()	{}
	
}
