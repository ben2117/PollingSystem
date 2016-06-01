<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../resources/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="1;url=../index.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log Out</title>
</head>
<body>
<% 
	polSysApp.logout();
	session.invalidate(); 
%>

<p>You have been logged out.</p>
<p>redirecting...</p>
</body>
<%@ include file="../resources/footer.jsp" %>
</html>