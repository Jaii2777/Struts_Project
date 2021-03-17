<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.io.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.action.VerifyUserAction"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
</head>
	<%
		String error=(String) request.getAttribute("error");
	%>
<body>
	<%
	
		if(error!=null) {%>
		<center>
			<p>Sorry! You are <%=error%> </p>
			<a href="http://localhost:8080/Struts/"> click ok </a>
			</center>
		<%}
	%>
	<%
		if(error==null) {%>
	<center>
	<form method="post" action ="verifyUser.do"> <br></br>
  	  Enter you User name: <input type="text" name="uname" /><br></br>
   	  					   <input type="submit" value="Submit" /></br>
   	 </center>
		<%}
	 %>
</form>
</body>
</html>