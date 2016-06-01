<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="resources/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {

		$('.cb').change(function() {

			if ($(this).is(":checked")) {

				$('#closingPolls').removeAttr('disabled');

			}

			else {

				var isChecked = false;

				$('.cb').each(function() {

					if ($(this).is(":checked")) {

						$('#closingPolls').removeAttr('disabled');

						isChecked = true;

					}

				});

				if (!isChecked) {

					$('#closingPolls').attr('disabled', 'disabled');

				}

			}

		})

	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Group Eleven Polling System</title>

</head>

<body>

	<%@ include file="resources/menu.jsp"%>

	<form action="Controller/closepoll.jsp" method="POST">

		<%
			if (session.getAttribute("user") != null && polSysApp.getSession() != null) {
		%>

		<h1>
			<%
				out.print(session.getAttribute("user"));
			%>
			Account Summary
		</h1>

		<h2>Active Polls:</h2>


		<%
		if(polSysApp.getSessionUser().getOpenedPolls().size()!=0){
			out.print("<table border='1' cellpadding='5' cellspacing='0'");
			out.print("<tr>");
			out.print("<th> Select </th>");
			out.print("<th> Poll Title </th>");
			out.print("<th> Creator's Full Name </th>");
			out.print("<th> Creation Date </th>");
			out.print("<th> Meeting Location </th>");
			out.print("<th> Meeting Description </th>");
			out.print("<th> Total Votes </th>");
			out.print("</tr>");
		}
			for (Poll p : polSysApp.getSessionUser().getOpenedPolls()) {
					
					out.print("<tr>");
					out.print("<td><input class='cb' type='checkbox' name='polls' value='" + p.getId() + "'></td>");
					out.print("<td><a href='poll.jsp?poll=" + p.getId() + "'>" + p.getTitle() + "</a></td>");
					out.print("<td>" + p.getCreator() + "</td>");
					out.print("<td>" + p.getDate() + "</td>");
					out.print("<td>" + p.getLocation() + "</td>");
					out.print("<td>" + p.getDescription() + "</td>");
					out.print("<td>" + p.getTotalVotes() + "</td>");
					out.print("</tr>");

			}
			out.print("</table>");
		%><br>
		<button id="closingPolls" type="submit" disabled="disabled">Close
			Polls</button>
	</form>

	<h2>In-Active Polls:</h2>

	<%
	if(polSysApp.getSessionUser().getClosedPolls().size()!=0){
		out.print("<table border='1' cellpadding='5' cellspacing='0'");
		out.print("<tr>");
		out.print("<th> Poll Title </th>");
		out.print("<th> Creator's Full Name </th>");
		out.print("<th> Creation Date </th>");
		out.print("<th> Meeting Location </th>");
		out.print("<th> Meeting Description </th>");
		out.print("<th> Total Votes </th>");
		out.print("</tr>");
	}
		for (Poll p : polSysApp.getSessionUser().getClosedPolls()) {
				
				out.print("<tr>");
				out.print("<td><a href='poll.jsp?poll=" + p.getId() + "'>" + p.getTitle() + "</a></td>");
				out.print("<td>" + p.getCreator() + "</td>");
				out.print("<td>" + p.getDate() + "</td>");
				out.print("<td>" + p.getLocation() + "</td>");
				out.print("<td>" + p.getDescription() + "</td>");
				out.print("<td>" + p.getTotalVotes() + "</td>");
				out.print("</tr>");

		}
		out.print("</table>");
	%>

	<br>
	<br>
	<br>
	<br>
	<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>

	<%
		}
	%>

	<h1>
		<b>Public Open Polls</b>
	</h1>

	<%
		for (User u : polSysApp.getUsers().getUsers()) {
			if (u.getOpenedPolls().size() != 0) {
				out.println("<h2> Created by: " + u.getFullName() + "<br></h2>");

				out.print("<table border='1' cellpadding='5' cellspacing='0'");
				out.print("<tr>");
				out.print("<th> Poll Title </th>");
				out.print("<th> Creator's Full Name </th>");
				out.print("<th> Creation Date </th>");
				out.print("<th> Meeting Location </th>");
				out.print("<th> Meeting Description </th>");
				out.print("<th> Total Votes </th>");
				out.print("</tr>");
			}
			for (Poll p : u.getOpenedPolls()) {

				out.print("<tr>");
				out.print("<td>" + "<a href='poll.jsp?poll=" + p.getId() + "'>" + p.getTitle() + "</a>"
						+ "</td>");
				out.print("<td>" + p.getCreator() + "</td>");
				out.print("<td>" + p.getDate() + "</td>");
				out.print("<td>" + p.getLocation() + "</td>");
				out.print("<td>" + p.getDescription() + "</td>");
				out.print("<td>" + p.getTotalVotes() + "</td>");
				out.print("</tr>");

			}
			out.print("</table>");

		}
	%>
	<p>
		<a href=sorted.jsp> Sort By Poll Title </a>
	</p>

	<br>
	<br>
	<br>
	<br>
	<h2>~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</h2>
	<h1>
		<b>Public Closed Polls</b>
	</h1>

	<%
		for (User u : polSysApp.getUsers().getUsers()) {

			if (u.getClosedPolls().size() != 0) {
				out.println("<h2> Created by: " + u.getFullName() + "<br></h2>");
				out.print("<table border='1' cellpadding='5' cellspacing='0'");
				out.print("<tr>");
				out.print("<th> Poll Title </th>");
				out.print("<th> Creator's Full Name </th>");
				out.print("<th> Creation Date </th>");
				out.print("<th> Meeting Location </th>");
				out.print("<th> Meeting Description </th>");
				out.print("<th> Total Votes </th>");
				out.print("</tr>");
			}
			for (Poll p : u.getClosedPolls()) {

				out.print("<tr>");
				out.print("<td>" + "<a href='poll.jsp?poll=" + p.getId() + "'>" + p.getTitle() + "</a></td>");
				out.print("<td>" + p.getCreator() + "</td>");
				out.print("<td>" + p.getDate() + "</td>");
				out.print("<td>" + p.getLocation() + "</td>");
				out.print("<td>" + p.getDescription() + "</td>");
				out.print("<td>" + p.getTotalVotes() + "</td>");
				out.print("</tr>");

			}
			out.print("</table>");

		}
	%>
</body>

<%@ include file="resources/footer.jsp"%>

</html>