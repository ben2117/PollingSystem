<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../resources/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String pollID = request.getParameter("pollID"); %>
<meta http-equiv="Refresh" content=<%out.print("1;url=../poll.jsp?poll=" + pollID);%>>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>voting</title>
</head>
<body>
<%
	String voterName = request.getParameter("voterName");
	String[] options = request.getParameterValues("options");
	for(int i = 0; i < options.length; i++){
		polSysApp.vote(pollID,options[i],voterName);
	}
%>
<p><b>Thank you for voting</b></p>
<p>redirecting...</p>
</body>
<%@ include file="../resources/footer.jsp" %>
</html>