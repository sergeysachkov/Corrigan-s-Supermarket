package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import java.util.List;

public interface CustomerService {

    long addCustomer(Customer customer);
    long updateCustomer(Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId);

    void login(String user, String password);

    void addPaymentDetails(long customerId, PaymentDetails paymentDetails);
    public List<PaymentDetails> getPaymentDetails(long customerId);
    void deletePaymentDetails(long customerId, long  paymentDetailsId);
}
