package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
class Utils {
   public static Connection getConnection() {
	  Statement stmt = null;
      Connection connection = null;
      try {
         Class.forName("com.mysql.jdbc.Driver");
         String url="jdbc:mysql://localhost:3306/corrigan";
         // Connect to DB using DB URL, Username and password
         connection = DriverManager.getConnection(url, "root", "940615");
         // Create a statement
         stmt = connection.createStatement();
        
      } catch (Exception e) {
         e.printStackTrace();
      }
      return connection;
   }

}