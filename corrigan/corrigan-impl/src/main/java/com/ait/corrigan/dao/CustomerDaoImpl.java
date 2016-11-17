package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    private Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //return DriverManager.getConnection("jdbc:mysql://localhost:3306/corrigan","admin","admin");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/corrigan","root","2585");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }

    }
    public long addCustomer(Customer customer){return 0;}
    public long updateCustomer(Customer customer){return 0;}
    public void deleteCustomer(long customerId){}
    public Customer getCustomer(long customerId){
        return null;
    }

    public boolean checkCustomer(String user, String password){return false;}


}
