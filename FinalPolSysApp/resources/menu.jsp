<div style="text-align: right">
	<b>Hi,<%if(session.getAttribute("name") != null){ out.print(" " + session.getAttribute("name"));}%></b>
	<a href="index.jsp">Home</a>
	<%if(session.getAttribute("user") != null){%>
	<a href="createpoll.jsp">Create Poll</a>
	<a href="Controller/logout.jsp">logout</a>
	<%}else{%>
	<a href="login.jsp">Log-In</a>
	<%}%>
</div>