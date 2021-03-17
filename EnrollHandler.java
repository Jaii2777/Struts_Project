package com.handler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class EnrollHandler {
 
 	static DbConnection db=new DbConnection();
 	public static String enrollUser (String ans1,String ans2,String userName) 
 	{
 		Connection con = null;
      	PreparedStatement stmt = null;
		int userId=0;
		ResultSet rs=null;
      	try {
      		con=db.getConnection();
			System.out.println("inside the action andler"+ans1+" "+ans2+" "+userName);
			stmt=con.prepareStatement("select userId from userdetails where userName=?");
			stmt.setString(1,userName);
			rs=stmt.executeQuery();
			if(rs.next()) {
				System.out.println("fff");
				userId=rs.getInt(1);
				System.out.println("userId" +rs.getInt(1));
			}
			System.out.println("userId" +userId);
		  String sql = "insert into UserQaDetails (qId,userId,answer) value(?,?,?)";
          stmt = con.prepareStatement(sql);
          stmt.setInt(1,1);
          stmt.setInt(2, userId);
          stmt.setString(3, ans1);

          stmt.executeUpdate();  

          System.out.println("Updated answer 1");
          stmt.setInt(1, 2);
          stmt.setInt(2,userId);
          stmt.setString(3, ans2);
          stmt.executeUpdate();  
    		System.out.println("Updated answer 2");
    		return "success";
       } catch (Exception e) {
           e.printStackTrace();
       }
	   return "failure";
       }
}
 	

 