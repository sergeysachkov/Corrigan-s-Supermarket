package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.*;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/corrigan","root","2585");
        return con;
    }
    public long addCustomer(Customer customer){return 0;}
    public long updateCustomer(Customer customer){return 0;}
    public void deleteCustomer(long customerId){}
    public Customer getCustomer(long customerId){
        return null;
    }

    public boolean checkCustomer(String user, String password){return false;}


}
