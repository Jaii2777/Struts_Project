package com.handler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateUserHandler {

 	static DbConnection db=new DbConnection();
 	public static String validateUser (String ans1,String ans2,String uname) 
 	{
 		Connection con = null;
      	PreparedStatement stmt = null;
      	int userId=0,a=0,a1=0;
      	try {
      		con=db.getConnection();
		  String sql = "select userId from userdetails where userName=?";
          stmt = con.prepareStatement(sql);
          stmt.setString(1, uname);
          ResultSet rs=stmt.executeQuery();
          
          if(rs.next())  {
          	System.out.println("userId is"+rs.getInt(1));
          	userId=+rs.getInt(1);
          	rs.close();


          	String q="select qId from UserQaDetails where userId=? and answer=?";
          	stmt = con.prepareStatement(q);
          	stmt.setInt(1,userId);
          	stmt.setString(2,ans1);
          	rs=stmt.executeQuery();
          	if(rs.next()){
          	System.out.println(rs.getInt(1));
          	rs.close();
          	}
          	else {
          		return "WrongAns1";
          	}

          	
          	stmt = con.prepareStatement("select qId from UserQaDetails where userId=? and answer=?");
          	stmt.setInt(1,userId);
          	stmt.setString(2,ans2);
          	rs=stmt.executeQuery();
          	if(rs.next()){
          	System.out.println("ans 2"+rs.getInt(1));
          	rs.close();
          	}
          	else
          	{
          		return "WrongAns2";
          	}
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
