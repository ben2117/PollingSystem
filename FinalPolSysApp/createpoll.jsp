<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="resources/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="Javascript" type="text/javascript">
var counter = 1;
var limit = 5;
function addInput(divName){
     if (counter == limit)  {
          alert("You've reached your limits of " + counter + " inputs");
     }
     else {
          var newdiv = document.createElement('div');
          newdiv.innerHTML = "Option " + (counter + 1) + ": <input type='text' name='options'>";
          document.getElementById(divName).appendChild(newdiv);
          counter++;
     }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Poll</title>
</head>
<body>
<%@ include file="resources/menu.jsp" %>
<%if(session.getAttribute("user") != null){%>
	<form action="Controller/create-poll.jsp" method="post">
		<table style="display: inline-block;">
			<tr><td><p style="font-size:30px">Create new Poll</p></td></tr>
		 	<tr><td>Title: </td><td><input name="title" type="text"></td></tr>
		  	<tr><td>Description: </td><td><input name="description" type="text"></td></tr>
		  	<tr><td>Location: </td><td><input name="location" type="text"></td></tr>
		</table>
		<div id="addOptions">
          Option 1: <input type="text" name="options">
     </div>
	<input type="button" value="Add another option" onClick="addInput('addOptions');"></td><td><input value="Create" type="submit">
	</form>
	
<%}else{%>
	<p><b>You do not have access to create a new Poll!</b></p>
<%}%>
</body>
</body>
<%@ include file="resources/footer.jsp" %>
</html>