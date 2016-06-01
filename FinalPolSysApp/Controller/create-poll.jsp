<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../resources/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Refresh" content="1;url=../index.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creating a Poll</title>
</head>
<body>
<%
	String title = request.getParameter("title");
	String desc = request.getParameter("description");
	String loc = request.getParameter("location");
	String[] options = request.getParameterValues("options");
	String pollID = Integer.toString(polSysApp.getAllPolls().size()+1);
	polSysApp.createNewPoll(pollID, title, loc, desc);
	polSysApp.setFilePath(filePath);
	for(int i = 0; i < options.length; i++){
		System.out.println("pID: " + pollID + ", VOID: " + i + ", options: " + options[i]);
		System.out.println("pollTitle: " + polSysApp.getPoll(pollID).getTitle());
		polSysApp.createPollMeetingTime(pollID, Integer.toString(i), options[i]);
	}
%>	
<p><b>Poll Created</b></p>
<p>redirecting...</p>
</body>
<%@ include file="../resources/footer.jsp" %>
</html>