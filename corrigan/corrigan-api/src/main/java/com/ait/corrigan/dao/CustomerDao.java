package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

public interface CustomerDao {

    long addCustomer(Customer customer);
    long updateCustomer(Customer customer);
    void deleteCustomer(long customerId);
    Customer getCustomer(long customerId);
    boolean checkCustomer(String user, String password);

    void addPaymentDetails(long customerId, PaymentDetails paymentDetails);
    void updatePaymentDetails(long customerId, PaymentDetails paymentDetails);
    void deletePaymentDetails(long customerId, long paymentDetailsId);
    
    
    
    
}
