package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.PaymentDetails;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by root on 11/17/2016.
 */
public interface PaymentDao {
    void addPaymentDetails(long customerId, PaymentDetails paymentDetails) throws SQLException;
    void deletePaymentDetails(long customerId, long paymentDetailsId);
    List<PaymentDetails> getPaymentDetails(long customerId) throws SQLException;
    PaymentDetails getPaymentDetail(long id) throws SQLException;
}