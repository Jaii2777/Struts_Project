package com.handler;
import  com.handler.DbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class ChangePasswordHandler {
	static DbConnection db=new DbConnection();

 	public static String changePassword (String oldPass,String newPass,String userName) 
 	{
 		Connection con = null;
      	PreparedStatement stmt = null;
      	ResultSet rs=null;
      	try {
      	  con=db.getConnection();
		  System.out.println("yes");
		  String sql = "select userId from userdetails where userName=?  and password=?";
          stmt = con.prepareStatement(sql);
          stmt.setString(1, userName);
          stmt.setString(2,oldPass);
          rs=stmt.executeQuery();
          if(!rs.next()){
          	con.close();
        	  rs.close();
         	  stmt.close();
         	  System.out.println("hi");
          	return "wrongOldPassword";
          }
          else
          {
          	String sql1="update userdetails set password=? where userName=? and password=?";
            stmt=con.prepareStatement(sql1);
            stmt.setString(1,newPass);
            stmt.setString(2,userName);
            stmt.setString(3,oldPass);
            stmt.executeUpdate();  
            con.close();
            rs.close();
            stmt.close();
             System.out.println("hello");
            return "changed";
          }

       } catch (Exception e) {
           e.printStackTrace();
       }
	   return "error";
       }
	}

