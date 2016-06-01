<%@ page language="java" import = "polsys.PolSysApp" import="polsys.Poll" import="polsys.VoteOption" import="polsys.Users" import="polsys.User" import="polsys.Vote"%>
<% String filePath = application.getRealPath("WEB-INF/Polling.xml"); %>
<jsp:useBean id="polSysApp" class="polsys.PolSysApp" scope="application">
	<jsp:setProperty name="polSysApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean> 
<% 
	polSysApp.setFilePath(filePath); 
%>