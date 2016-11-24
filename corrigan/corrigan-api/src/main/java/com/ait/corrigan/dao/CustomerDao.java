package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;


import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    long addCustomer(Customer customer);
    long updateCustomer(Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId) throws SQLException;
    Customer getCustomerByID(long id) throws SQLException;
    List<Customer> getCustomers() throws SQLException;
    boolean checkCustomer(String user, String password);
}
