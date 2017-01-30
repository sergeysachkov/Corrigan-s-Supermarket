package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockControlDaoImpl implements StockControlDao {
	 public  static boolean checkStockControl (String username, String password){
	    	try(Connection connection = DaoUtil.getConnection();
	    			
	    	 PreparedStatement stmt=connection.prepareStatement("SELECT * FROM STOCKCONTROL WHERE USERNAME = ? AND PASSWORD = ?")){
	    		 stmt.setString(1, username);
	             stmt.setString(2, password);
	             System.out.println(stmt);
	             ResultSet result = stmt.executeQuery();
	             if(result.next()){
	            	 return true;
	             }
	    	 }
	    	catch (SQLException ex) {
				System.out.println("Login error -->" + ex.getMessage());
				return false;
			      }
		 return false;
		 }

	}

