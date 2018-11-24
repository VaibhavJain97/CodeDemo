<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>SHB Banking Registration</title>
	<link type="text/css" rel="stylesheet" href="styles/register.css">
</head>
<body>
<div id="register">
	<h1 align="center">Registration Form</h1>
	<hr>
	<form:form action="registerForm" modelAttribute="register" method="post" name="registration">
	<div class="tablecnt">
		<table>
			<tr>
				<th></th>
			</tr>
			<tr>
				<td>First Name: </td>
				<td><form:input path="firstName"/></td>
				<td><form:errors path="firstName" cssClass="error-message"/></td>
				<td><form:hidden path="customerId"/></td>
			</tr>
			<tr>
				<td>Last Name: </td>
				<td><form:input path="lastName"/></td>
				<td><form:errors path="lastName" cssClass="error-message"/></td>
			</tr>
			<tr>
				<td>Email ID: </td>
				<td>
					<form:input path="emailId"/>
				</td>
				<td><form:errors path="emailId" cssClass="error-message"/></td>
			</tr>
			<tr>
				<td>Mobile Number: </td>
				<td>
					<form:input path="mobileNumber"/>
					
				</td>
				<td><form:errors path="mobileNumber" cssClass="error-message"/></td>
			</tr>
			<tr>
				<td>Address Line 1: </td>
				<td><form:textarea path="addressLine1"/></td>
			</tr>
			<tr>
				<td>Address Line 2: </td>
				<td><form:textarea path="addressLine2"/></td>
			</tr>
			<tr>
				<td>City: </td>
				<td><form:select path="city">
						<form:option value="Vadodara">Vadodara</form:option>
						<form:option value="Mumbai">Mumbai</form:option>
						<form:option value="Pune">Pune</form:option>
						<form:option value="Hyderabad">Hyderabad</form:option>
						<form:option value="Bangalore">Bangalore</form:option>
						<form:option value="Chennai">Bangalore</form:option>
						<form:option value="New Delhi">Bangalore</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>State: </td>
				<td><form:select path="state">
						<form:option value="Gujarat">Gujarat</form:option>
						<form:option value="Maharashtra">Maharashtra</form:option>
						<form:option value="AP">Andhra Pradesh</form:option>
						<form:option value="TN">Tamilnadu</form:option>
						<form:option value="delhi">New Delhi</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Pin Code: </td>
				<td>
					<form:input path="pincode"/>
					
				</td>
				<td><form:errors path="pincode" cssClass="error-message"/></td>
			</tr>
			<tr>
				<td>Gender: </td>
				<td>
					<form:radiobutton path="gender" value="Male"/>Male
					<form:radiobutton path="gender" value="Female"/>Female
				</td>
			</tr>
			
			<tr>
				<td>Date Of Birth(yyyy-mm-dd): </td>
				<td>
					<form:input path="dateOfBirth"/>
				</td>
				<td><form:errors path="dateOfBirth" cssClass="error-message"/></td>
			</tr>
			<tr>
				<td>Registration Fees: </td>
				<td>
					<form:input path="registrationFees"/>
					
				</td>
				<td><form:errors path="registrationFees" cssClass="error-message"/></td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td>
					<form:password path="password"/>
				</td>
				<td><form:errors path="password" cssClass="error-message"/></td>
			</tr>
			<tr>
				<td>Confirm Password: </td>
				<td>
					<form:password path="confirmPassword"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="${buttonLabel }" name="Register"></td>
			</tr>
		</table>
	</div>
	</form:form>
	
	<hr>
	<h3 align="center">Existing Registrations</h3>
	
	<c:if test="${!empty registers}">
	<table>
		<tr>
			<th>Customer ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email ID</th>
			<th>Mobile Number</th>
			<th>Address</th>
			<th>PinCode</th>
			<th>Date of Birth</th>
			<th>Gender</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${registers }" var="register">
			<tr>
				<td>${register.customerId }</td>
				<td>${register.firstName }</td>
				<td>${register.lastName }</td>
				<td>${register.emailId }</td>
				<td>${register.mobileNumber }</td>
				<td>${register.addressLine1 }, ${register.addressLine2 }, ${register.city }, ${register.state }</td>
				<td>${register.pincode }</td>
				<td>${register.dateOfBirth }</td>
				<td>${register.gender }</td>
				
				<td>
					<a href="delete/${register.customerId }">Delete</a>
					<a href="edit/${register.customerId }">Edit</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	</c:if>
</div>
</body>
