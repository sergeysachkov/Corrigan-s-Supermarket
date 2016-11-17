package com.ait.corrigan.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ait.corrigan.models.user.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public enum CustomerDAO {
	 instance;
	
	public Customer checkLogin(String customerName, String password) {
	      Connection connection = Utils.getConnection();
	      Customer customer = null;

	      try {
	    	  
	    	  PreparedStatement psmt = connection
	                 .prepareStatement("SELECT * FROM USER WHERE NAME = ? AND PASSWORD = ?");
	         
	         psmt.setString(1, customerName);
	         psmt.setString(2, password);
	         ResultSet rs = psmt.executeQuery();
	         if (rs.next()) {
	            customer = new Customer(rs.getLong("customerId"), rs.getString("customerName"),rs.getString("customerSurname"),
	                  rs.getString("Password"), rs.getString("phoneNumber"),rs.getString("email"),rs.getDate("customerDateOfBirth"),rs.getLong("adressId"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return customer;
	   }
}
