<%@ page import="java.util.*, java.io.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.action.ChangePasswordAction"%>
<%@ page import="com.action.EnrollAction"%>

<!DOCTYPE html>
<html>
<head>
<title> Password Authentication</title>
</head>
<%
	String message=(String)request.getAttribute("message");
%>
<body>
	<%
			if(message!=null) {%>
				<span>Hey <%=message%> </span>
				<a href="View.do">ok</a>
			<%}
	%>
	<%
	if(message==null) {%>
	<center>
	
		<a href="enroll.do">Click  Here to Enroll</a><br><br/>
		
		<a href="changePassword.do">Click to Change Password</a><br></br>
		
		<a href="logout.do"> LogOut</a>
			
	</center>
	<%}
	%>

	
</body>
</html>

