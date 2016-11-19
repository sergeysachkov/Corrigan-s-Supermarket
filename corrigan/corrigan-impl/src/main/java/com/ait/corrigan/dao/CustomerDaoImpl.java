package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ait.corrigan.models.user.Customer;

public class CustomerDaoImpl implements CustomerDao{

    public long addCustomer(Customer customer){return 0;}
    public long updateCustomer(Customer customer){return 0;}
    public void deleteCustomer(long customerId){}
    public Customer getCustomer(long customerId){
        return null;
    }

    public boolean checkCustomer(String user, String password){
    	 try(Connection connection = DaoUtil.getConnection();
    	 PreparedStatement stmt=connection.prepareStatement("SELECT * FROM USER WHERE CUSTOMER_NAME = ? AND PASSWORD = ?")){
    		 stmt.setString(1, user);
             stmt.setString(2, password);
             stmt.executeUpdate();
    	 }
             catch (SQLException e) {
		         e.printStackTrace();
		      }
	 return false;
	 }

}
