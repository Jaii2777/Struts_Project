package com.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VerifyUserHandler {

 	static DbConnection db=new DbConnection();
 	public static String verifyUser (String uname) 
 	{
 		Connection con = null;
      	PreparedStatement stmt = null;
      	try {
      		con=db.getConnection();
		  String sql = "select userId from userdetails where userName=?";
          stmt = con.prepareStatement(sql);
          stmt.setString(1, uname);
          ResultSet rs=stmt.executeQuery();
          System.out.println("sdsdsds");
          if(rs!=null)  {
          	rs.close();
          	con.close();
          	stmt.close();
          	return "verified";
          } 
          else
          {
          	rs.close();
          	con.close();
          	stmt.close();
          	return "failed";
          }
       } catch (Exception e) {
           e.printStackTrace();
       }
	   return "error";
       }
}
 