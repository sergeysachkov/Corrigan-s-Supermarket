package com.ait.corrigan.services;

import com.ait.corrigan.models.user.PaymentDetails;

import java.util.List;

/**
 * Created by root on 11/17/2016.
 */
public interface PaymentService {
    long addPaymentDetails(long customerId, PaymentDetails paymentDetails);
    public List<PaymentDetails> getPaymentDetails(long customerId);
    void deletePaymentDetails(long customerId, long  paymentDetailsId);
    PaymentDetails getPaymentDetail(long id);
}
