<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHBBanking</title>
<script type="text/javascript" src="../script/validation.js"></script>
</head>
<body>
<form:form method="post" name="createAccount" action="createAccount" >
	<div>
		<table align="center">
			<tr>
				<th colspan="3">Account Creation</th>
			</tr>
			<tr>
				<td>Account Type:</td>
				<td>
					<form:select path="accountType">
						<form:option value="SAVINGS">Savings</form:option>
						<form:option value="CURRENT">Current</form:option>
						<form:option value="RD">Recurring Deposit</form:option>
						<form:option value="FD">Fixed Deposit</form:option>
						
					</form:select>
				</td>
				<td><form:hidden path="customerId"/></td>
			</tr>
			
			<tr>
				<td>Opening Balance:</td>
				<td>
					<form:input type="text" name="balance" path="openingBalance" size="20"></form:input>  
				</td>
				<td>
				<div id="openingBalErrMsg" class="errMsg"></div>
			</td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td>
					<form:input path="description" type="text" name="description" size="20"></form:input>
				</td>
				<td><form:hidden path="openingDate" value=""/></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Create Account" name="createAcc" >
				</td>
			</tr>
		
		</table>
	
	</div>

</form:form>
</body>
</html>