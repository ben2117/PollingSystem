<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="resources/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.cb').change(function () {
                if ($(this).is(":checked")) {
                    $('#voting').removeAttr('disabled');
                }
                else {
                    var isChecked = false;
                    $('.cb').each(function () {
                        if ($(this).is(":checked")) {
                            $('#voting').removeAttr('disabled');
                            isChecked = true;
                        }
                    });
                    if (!isChecked) {
                        $('#voting').attr('disabled', 'disabled');
                    }
                }
 
 
            })
        });
    </script>
<title>Poll's Details</title>
</head>
<body>
<%@ include file="resources/menu.jsp" %>
<h1>Poll's Details</h1>
<%
	String pollID = request.getParameter("poll");
%>
<form action="Controller/vote.jsp" method="POST">
<input type="hidden" name="pollID" value="<%out.print(pollID);%>">
	<table>       
	        <tr><td><b>Poll Title: </b></td><td><%out.print(polSysApp.getPoll(pollID).getTitle());%></td></tr>
	        <tr><td><b>Creator's Full Name: </b></td><td><%out.print(polSysApp.getPoll(pollID).getCreator());%></td></tr>
	        <tr><td><b>Creation Date: </b></td><td><%out.print(polSysApp.getPoll(pollID).getDate());%></td></tr>
	        <tr><td><b>Meeting Location: </b></td><td><%out.print(polSysApp.getPoll(pollID).getLocation());%></td></tr>
	        <tr><td><b>Meeting Description: </b></td><td><%out.print(polSysApp.getPoll(pollID).getDescription());%></td></tr>     
	</table>
	
	
		<%if(polSysApp.getPoll(pollID).getStatus().equals("closed") || polSysApp.getSession() != null){%>
			<table>
				<% 
					for(VoteOption vo: polSysApp.getPoll(pollID).getVoteOptions()){
						out.print("<tr><td>" + vo.getVoteOption() + "</td><td>");
						for(Vote v : vo.getVotes()){
							out.print(v.getVoterName() + ", ");
						}
						out.print("</td></tr>");
					}
				%>
			</table>
		<%} else {%>
		<table>
			<tr><td><b>Select Meeting Time</b><br>
					<%for(VoteOption vo: polSysApp.getPoll(pollID).getVoteOptions()){
						out.print("<input class='cb' type='checkbox' name='options' value='"+ vo.getId() +"'> " + vo.getVoteOption() + " ("+ vo.getVoteCount() +" voted)<br>");
					}%>
			</td></tr>
	</table>
	<b>Name: </b><input name="voterName" type="text" value="Annonymous">
	<button id="voting" type="submit" disabled="disabled">Vote</button>
	<%}%>
</form>
</body>

<%@ include file="resources/footer.jsp" %>
</html>