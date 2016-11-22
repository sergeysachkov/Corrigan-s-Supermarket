package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
public long addCustomer(Customer customer) { 
    	
    	        try(Connection connection = DaoUtil.getConnection();
    	            PreparedStatement stmt=connection.prepareStatement("INSERT INTO customer (idcustomer, customer_name , customer_surname, customer_login, password, phone_number, email, date_of_birth) " +
    	                    "VALUES (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
    	            stmt.setLong(1, customer.getCustomerId());
    	            stmt.setString(2, customer.getCustomerName());
    	            stmt.setString(3, customer.getCustomerSurname());
    	            stmt.setString (4, customer.getCustomerLogin());
    	            stmt.setString(5, customer.getPassword());
    	            stmt.setString(6, customer.getPhoneNumber());
    	            stmt.setString(7, customer.getEmail());
    	            stmt.setDate(8, new Date(customer.getCustomerDateOfBirth().getTime()));
    	            stmt.executeUpdate();
    	        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	        return 1;
    			}
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
