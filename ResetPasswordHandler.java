package com.handler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResetPasswordHandler {

 	static DbConnection db=new DbConnection();
 	public static String resetPassword (String newPass,String confirmPass,String userName) 
 	{
 		   Connection con = null;
       PreparedStatement stmt = null;
      	int userId=0,a=0,a1=0;
      	try {
      		con=db.getConnection();
          System.out.println("userName is"+userName);
		    String sql = "update userdetails set password=? where userName=?";
          stmt = con.prepareStatement(sql);
          stmt.setString(1, newPass);
          stmt.setString(2,userName);
          stmt.executeUpdate();
          System.out.println("password reseted...");
          return "success";
       } catch (Exception e) {
           e.printStackTrace();
       }
	   return "error";
       }
}
