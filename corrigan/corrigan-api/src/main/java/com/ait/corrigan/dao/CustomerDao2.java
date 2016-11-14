package com.ait.corrigan.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ait.corrigan.models.user.Customer;

//import model.list;
//import model.User;
public enum CustomerDao2 {
	 instance;
	
	public Customer checkLogin(String CustName, String Password) {
	      Connection connection = Utils.getConnection();
	      Customer customer = null;

	      try {
	         PreparedStatement psmt = connection
	               .prepareStatement("SELECT * FROM CUSTONER WHERE CUSTNAME = ? AND PASSWORD = ?");
	         psmt.setString(1, CustName);
	         psmt.setString(2, Password);
	         ResultSet rs = psmt.executeQuery();
	         if (rs.next()) {
	            customer = new Customer(rs.getInt("Cust_id"), rs.getString("CustName"),
	                  rs.getString("Password"), rs.getString("Address"),rs.getDate("Date_of_birth"),rs.getString("EmailAddress"),rs.getString("PhoneNo"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return customer;
	   }

}