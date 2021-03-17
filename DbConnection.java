package com.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DbConnection {

	public Connection getConnection() {
		Connection con = null;
      try {
         con = DriverManager.getConnection ("jdbc:mysql://localhost/struts","root", "root");
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      return con;
	}
}