package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    long addCustomer(Customer customer);
    long updateCustomer(Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId) throws SQLException;
    List<Customer> getCustomers() throws SQLException;
   // boolean checkCustomer(String customerLogin, String password);
    static void checkCustomer(String customerLogin, String password){};
}
