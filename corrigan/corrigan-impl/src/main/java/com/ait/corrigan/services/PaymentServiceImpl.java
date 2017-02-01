package com.ait.corrigan.services;

import com.ait.corrigan.dao.PaymentDao;
import com.ait.corrigan.dao.PaymentDaoImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.PaymentDetails;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by root on 11/17/2016.
 */
public class PaymentServiceImpl implements PaymentService{
    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private PaymentDao paymentDao;

    public PaymentServiceImpl() {
        this.paymentDao = new PaymentDaoImpl();
    }

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public long addPaymentDetails(long customerId, PaymentDetails paymentDetails){
        try {
            if(paymentDetails.getCardNo() != null
                    && (paymentDetails.getCardNo().length() != 16 || !StringUtils.isNumeric(paymentDetails.getCardNo()))){
                throw new CorriganException("Card Number should be 16 digits long and be numeric only");
            }

            if(paymentDetails.getCardNo() != null
                    && (paymentDetails.getCvv2().length() != 3 || !StringUtils.isNumeric(paymentDetails.getCardNo()))){
                throw new CorriganException("CCV2 should be 3 digits long and be numeric only");
            }

            return paymentDao.addPaymentDetails(customerId, paymentDetails);
        } catch (SQLException e) {
            logger.error("Error occurred!", e);
            throw new CorriganException(e.getMessage());
        }
    }
    
    public long updatePaymentDetails(long customerId, PaymentDetails paymentDetails){
    	try {
            return paymentDao.updatePaymentDetails(customerId, paymentDetails);

    }catch (SQLException e) {
        logger.error("Error occurred!", e);
        throw new CorriganException(e.getMessage());
    }
    }
    public List<PaymentDetails> getPaymentDetails(long customerId){
        try {
            return paymentDao.getPaymentDetails(customerId);
        } catch (SQLException e) {
            logger.error("Error occurred!", e);
            throw new CorriganException(e.getMessage());
        }
    }
    public List<String> getPaymentCards(long customerId){
        try {
            return paymentDao.getPaymentCards(customerId);
        } catch (SQLException e) {
            logger.error("Error occurred!", e);
            throw new CorriganException(e.getMessage());
        }
    }
    public void deletePaymentDetails(long customerId, long paymentDetailsId){
        paymentDao.deletePaymentDetails(customerId, paymentDetailsId);
    }
    public PaymentDetails getPaymentDetail(long id){
        try {
            return paymentDao.getPaymentDetail(id);
        } catch (SQLException e) {
            logger.error("Error occurred!", e);
            throw new CorriganException(e.getMessage());
        }
    }
}
