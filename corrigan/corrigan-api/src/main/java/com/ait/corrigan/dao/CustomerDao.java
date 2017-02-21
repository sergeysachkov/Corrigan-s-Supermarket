package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;


import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    long addCustomer(Customer customer);
    long updateCustomer(long customerId, Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId) throws SQLException;
    Customer getCustomerByLogin(String login) throws SQLException;
    Customer getCustomerByID(long id) throws SQLException;
    public long getCustomerIdByLogin(String login) throws SQLException;
    List<Customer> getCustomers() throws SQLException;
    boolean checkCustomer(String customerLogin, String password);
}
