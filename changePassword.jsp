<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.action.ChangePasswordAction"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Example</title>
</head>
<%
	String error=(String)request.getAttribute("message");
%>

<body>
	<%
	
	 if (error!=null) {%>
	 <center>
	 		<span>Sorry! <%=request.getAttribute("message")%> </span>
	 		<a href="changePassword.do">ok</a>
			</center>
	 <%}
	
	%>
	<%
		if(error==null) {%>
	<center>
	<form method="post" action ="changePassword.do"> <br></br>
    Enter your Old Password: <input type="text" name="q1" /><br></br>
    Enter you new Password: <input type="text" name="q2" /><br></br>
	Enter you Conf Password: <input type="text" name="q3" /><br></br>
   	<input type="submit" value="Change" /></br>
   	 </center>
		<%}
	 %>
</form>
</body>
</html>