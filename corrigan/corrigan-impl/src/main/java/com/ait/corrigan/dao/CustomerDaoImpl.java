package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;

public class CustomerDaoImpl implements CustomerDao{

    public long addCustomer(Customer customer){return 0;}
    public long updateCustomer(Customer customer){return 0;}
    public void deleteCustomer(long customerId){}
    public Customer getCustomer(long customerId){
        return null;
    }

    public boolean checkCustomer(String user, String password)throws SQLException {
    	 try(Connection connection = getConnection();
    			 PreparedStatement psmt = connection
    		               .prepareStatement("SELECT * FROM USER WHERE CUSTOMER_NAME = ? AND PASSWORD = ?"£©
    		               psmt.setString(1, name);
    		               psmt.setString(2, password);
    			           stmt.executeUpdate();
    	                   
    			 catch (SQLException e) {
    		         e.printStackTrace();
    		      }
    	 return false;
    	 }


}
