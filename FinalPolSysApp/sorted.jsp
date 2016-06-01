<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<%@ include file="resources/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">

        $(function () {

            $('.cb').change(function () {

                if ($(this).is(":checked")) {

                    $('#closingPolls').removeAttr('disabled');

                }

                else {

                    var isChecked = false;

                    $('.cb').each(function () {

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

<title>Group Nine Polling System</title>

</head>

<body>

<%@ include file="resources/menu.jsp" %>


<h1><b>Public Open Polls</b></h1>
<%
for(Poll p : polSysApp.sortPollsByTitle()){
	out.print("<table border='1' cellpadding='5' cellspacing='0'");
    out.print("<tr>");
      out.print("<th> Poll Title </th>");
      out.print("<th> Creator's Full Name </th>");
      out.print("<th> Creation Date </th>");
      out.print("<th> Meeting Location </th>");
      out.print("<th> Meeting Description </th>");
      out.print("<th> Total Votes </th>");
    out.print("</tr>");
    out.print("<tr>");
      out.print("<td>" + "<br><a href='poll.jsp?poll="+ p.getId() +"'>" + p.getTitle() + "</a></br>" + "</td>");
      out.print("<td>" + p.getCreator() + "</td>");
      out.print("<td>" + p.getDate() + "</td>");
      out.print("<td>" + p.getLocation() + "</td>");
      out.print("<td>" + p.getDescription() + "</td>");
      out.print("<td>" + p.getTotalVotes() + "</td>");
    out.print("</tr>");
  out.print("</table>");
}


%>

</body>

<%@ include file="resources/footer.jsp" %>

</html>