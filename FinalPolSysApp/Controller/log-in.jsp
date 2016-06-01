<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../resources/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="1;url=../index.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login controller</title>
</head>
<body>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if(polSysApp.login(username,password) != null){
		session.setAttribute("user", polSysApp.getSessionUser().getUserName());
		session.setAttribute("name", polSysApp.getSessionUser().getFullName());%>
		<p>Logged in successfully as <%out.print(session.getAttribute("user"));%></p>
		<p>redirecting...</p>
	<%}else{%>
		<p>Incorrect Login Details!</p>
	<%}%>
</body>
<%@ include file="../resources/footer.jsp" %>
</html>