<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Successful</title>
</head>
<body>
	<h1>Welcome! You are logged in. Your customer ID is ${session.getAttribute("custId").toString() }</h1>
</body>
</html>