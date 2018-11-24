function validateRegistration()	{
	var flag=false;
	var fname=registration.firstName.value;
	var lname=registration.lastName.value;
	var dob=Date.parse(registration.dateOfbirth.value);
	var today=new Date();
	var pin=registration.pincode.value;
	var email=registration.email.value;
	var mobile=registration.mobile.value;
	var custPwd=registration.custPwd.value;
	var confirmPwd=registration.confirmCustPwd.value;
	
	if(!fname.match(/^[A-Za-z]{3,}$/) || fname==null || fname=="")
		{
			flag=false;
			removeErrorMsg();
			document.getElementById('fnameErrMsg').innerHTML="*Enter valid Firstname.";
		}
	else if(!lname.match(/^[A-Za-z]{3,}$/) || lname==null || lname=="")
	{
		flag=false;
		removeErrorMsg();
		document.getElementById('lnameErrMsg').innerHTML="*Enter valid Lastname.";
	}
	else if(!pin.match(/^\d{6}$/) || pin==null || pin=="")
	{
		flag=false;
		removeErrorMsg();
		document.getElementById('pinErrMsg').innerHTML="*Enter valid 6-digit pincode.";
	}
	else if(!email.match(/^[a-z0-9._]{1,}@gmail.com$/) || email==null || email=="")
	{
		flag=false;
		removeErrorMsg();
		document.getElementById('emailErrMsg').innerHTML="*Enter valid email ID.";
	}
	else if(!mobile.match(/^\d{10}$/) || mobile==null || mobile=="")
	{
		flag=false;
		removeErrorMsg();
		document.getElementById('mobileErrMsg').innerHTML="*Enter valid 10-digit mobile number.";
	}
	else if(custPwd==null || custPwd=="")
	{
		flag=false;
		removeErrorMsg();
		document.getElementById('pwdErrMsg').innerHTML="*Password cannot be null.";
	}
	else if(dob==null || dob=="" || dob>today)
	{
		flag=false;
		removeErrorMsg();
		document.getElementById('dobErrMsg').innerHTML="*Enter valid date of birth.";
	}
	else if(confirmPwd!=custPwd  || confirmPwd==null || confirmPwd=="")
	{
		flag=false;
		removeErrorMsg();
		document.getElementById('confirmPwdErrMsg').innerHTML="*Both passwords must match.";
	}
	else 
	{	flag=true;
		removeErrorMsg();
	}
	return flag;
	
}

function removeErrorMsg()	{
	document.getElementById('fnameErrMsg').innerHTML="";
	document.getElementById('lnameErrMsg').innerHTML="";
	document.getElementById('pinErrMsg').innerHTML="";
	document.getElementById('emailErrMsg').innerHTML="";
	document.getElementById('mobileErrMsg').innerHTML="";
	document.getElementById('pwdErrMsg').innerHTML="";
	document.getElementById('confirmPwdErrMsg').innerHTML="";
}

function validateOpeningBalance()	{
	var flag=false;
	var accType=createAccount.accountType.value;
	var openingBal=createAccount.balance.value;
	
	if(openingBal==null || openingBal=="")
	{
		flag=false;
		document.getElementById('openingBalErrMsg').innerHTML="*Opening balance cannot be null.";
	}
	else if(accType=="SAVINGS" && openingBal<5000)
	{
		flag=false;
		document.getElementById('openingBalErrMsg').innerHTML="*Minimum Opening balance for SAVINGS account is Rs.5000.";
	}
	else if(accType=="CURRENT" && openingBal<8000)
	{
		flag=false;
		document.getElementById('openingBalErrMsg').innerHTML="*Minimum Opening balance for CURRENT account is Rs.8000.";
	}
	else if(accType=="RD" && openingBal<10000)
	{
		flag=false;
		document.getElementById('openingBalErrMsg').innerHTML="*Minimum Opening balance for RD account is Rs.10000.";
	}
	else if(accType=="FD" && openingBal<10000)
	{
		flag=false;
		document.getElementById('openingBalErrMsg').innerHTML="*Minimum Opening balance for FD account is Rs.10000.";
	}
	else
	{
		flag=true;
		document.getElementById('openingBalErrMsg').innerHTML="";
	}
	
	return flag;
}


function validateWithdrawalAmount()	{
	var flag=false;
	var amt=depositWithdrawal.amount;
	
	if(amount<=0)
		{
		flag=false;
		document.getElementById('amtErrMsg').innerHTML="*Enter a valid amount.";
		}
	else
		{
		flag=true;
		document.getElementById('amtErrMsg').innerHTML="";
		}
}

function validateToDate()	{
	var flag=false;
	var fromDateString=trSummary.fromDate.value;
	var toDateString=trSummary.toDate.value;
	var fromDate=Date.parse(fromDateString);
	var toDate=Date.parse(toDateString);
	var today = new Date();
	
	if(fromDate>toDate)
	{
		flag=false;
		document.getElementById('toDateErrMsg').innerHTML="*To Date cannot be before From Date.";
	}
	else if(fromDate>today)
	{
		flag=false;
		document.getElementById('fromDateErrMsg').innerHTML="*Enter valid from date.";
	}
	else if(toDate>today)
	{
		flag=false;
		document.getElementById('toDateErrMsg').innerHTML="*Enter valid To date.";
	}
	else
	{
		flag=true;
		document.getElementById('toDateErrMsg').innerHTML="";
	}
		
	return flag;
}
