<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<title>User Login</title>
<body>
	<center>
	<h1>User Login</h1>
	 <form name="loginForm" id="form-id" method="post" action="j_security_check">
            <p>User name: <input type="text" id="u_id" name="j_username" /></p>
            <p>Password: <input type="password" id="password-id" name="j_password"/></p>
			<p><input type="submit" value="submit" /></p>
        </form>

        <!-- <a href="getUserName.do"> Reset Password </a> -->
        <a href="getUserName.do"> Reset Password </a>
</body>
</html>