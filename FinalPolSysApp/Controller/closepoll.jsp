
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../resources/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="1;url=../index.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>closing polls</title>
</head>
<body>
	<%
		String[] polls = request.getParameterValues("polls");
		for (int i = 0; i < polls.length; i++) {
			polSysApp.closePoll(polls[i]);
			out.print("<p><b>" + polSysApp.getPoll(polls[i]).getTitle()
					+ " has been closed!</b></p>");
		}
	%>
	<p>redirecting...</p>
</body>
<%@ include file="../resources/footer.jsp"%>
</html>
