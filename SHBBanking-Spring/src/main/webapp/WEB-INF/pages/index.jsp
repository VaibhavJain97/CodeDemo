<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SHB Banking</title>
<link type="text/css" rel="stylesheet" href="styles/mystyles.css">
</head>
<body>

	<h1 align="center">SHB Banking</h1>
	<hr>
	<form:form action="validateLogin" modelAttribute="login">
	<div id="centercnt">
	<div id="cnt">

	<img alt="Banking" src="images/money.jpg" width="800" height="500">
	</div>

	<div id="loginForm">

		<table>
			<tr>
				<th colspan="3">Login Form</th>
			</tr>
			
			<tr>
				<td>UserName: </td>
				<td>
					<form:input path="userName"/>
				</td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td>
					<form:password path="userPassword"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<div class="btnStyle">
					<a href="registerRedirect" style="color:white; font-family: Arial; font-weight: bold; font-size: 13px; padding-left: 15px;" >SignUp</a>
					</div>
				</td>
				<td>
					<input class="btnStyle" type="submit" value="Login" name="Login"/>
				</td>
				
			</tr>
		</table>
		</div>
		</div>
	</form:form>
<hr>
</body>
</html>