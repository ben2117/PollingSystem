<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="resources/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Login and Creation</title>
</head>
<body>
<%@ include file="resources/menu.jsp" %>
<h1>Log in to your Account</h1>
<form action="Controller/log-in.jsp" method="POST">
		<table style="display: inline-block;">
			<tr><td><p style="font-size:30px">Login</p></td></tr><tr><td></td></tr>
	  		<tr><td>Username</td><td><input name="username" type="text"></td></tr>
	 		<tr><td>Password</td><td><input name="password" type="password"></td></tr>
			<tr><td></td><td><input value="Login" type="submit"></td></tr>
		</table>
</form>
<h1>Create an Account</h1>
<form action="Controller/register.jsp" method="post">
		<table style="display: inline-block;">
			<tr><td><p style="font-size:30px">Register</p></td></tr>
		 	<tr><td>Username</td><td><input name="username" type="text"></td></tr>
		  	<tr><td>FullName</td><td><input name="fullName" type="text"></td></tr>
		  	<tr><td>Password</td><td><input name="password" type="password"></td></tr>
		  	<tr><td></td><td><input value="Register" type="submit"></td></tr>
		</table>
	</form>
</body>
<%@ include file="resources/footer.jsp" %>
</html>