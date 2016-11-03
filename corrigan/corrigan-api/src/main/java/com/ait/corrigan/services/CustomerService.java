package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

public interface CustomerService {

    long addCustomer(Customer customer);
    long updateCustomer(Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId);

    void login(String user, String password);

    void addPaymentDetails(long customerId, PaymentDetails paymentDetails);
    void updatePaymentDetails(long customerId, PaymentDetails paymentDetails);
    void deletePaymentDetails(long customerId, long  paymentDetailsId);
}
