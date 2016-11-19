package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{

    public long addCustomer(Customer customer){return 0;}
    public long updateCustomer(Customer customer){return 0;}
    public void deleteCustomer(long customerId){}
    public Customer getCustomer(long customerId) throws SQLException {
        Customer customer = new Customer();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from customer where idpayment=?")) {
            stmt.setLong(1, customerId);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                customer.setCustomerId(resultSet.getLong("idcustomer"));
                customer.setCustomerDateOfBirth(resultSet.getDate("date_of_birth"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerSurname(resultSet.getString("customer_surname"));
                customer.setEmail(resultSet.getString("email"));

            }
        }
        return customer;
    }

    public List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from customer")) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getLong("idcustomer"));
                customer.setCustomerDateOfBirth(resultSet.getDate("date_of_birth"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerSurname(resultSet.getString("customer_surname"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        }
        return customers;
    }

    public boolean checkCustomer(String user, String password){return false;}


}
