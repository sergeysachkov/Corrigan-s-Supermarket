package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.util.List;

public interface CustomerService {

    long addCustomer(Customer customer);
    long updateCustomer(Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId);
    List<Customer> getCustomers();

    void login(String user, String password);
}
