package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    long addCustomer(Customer customer);
    long updateCustomer(long customerId, Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId);
    Customer getCustomerByID(long id);
    Customer getCustomerByLogin(String login);
    List<Customer> getCustomers();

    void login(String customerLogin, String password);
    public long getCustomerIdByLogin(String login);
   
}
