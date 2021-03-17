<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.action.ValidateUserAction"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secret Questions to Reset Password</title>
</head>
	
	<%
		String error=(String)request.getAttribute("WrongAns");
	%>

<body>
	<%
	 if (error!=null) {%>
	 		<span>Here is your error <%=request.getAttribute("WrongAns")%> </span>
	 		<a href="http://localhost:8080/Struts/verifyUser.jsp">ok</a>

	 <%}
	%>
	<% 
	if(error==null){%>
	<center>
	<form method="post" action ="validateUser.do"> <br></br>
    Enter you First name: <input type="text" name="ans1" /><br></br>
    Enter you Nick name: <input type="text" name="ans2" /><br></br>
   	<input type="submit" value="Check" /></br>
   	 </center>
   	 <%}
   	 %>
</form>
</body>
</html>