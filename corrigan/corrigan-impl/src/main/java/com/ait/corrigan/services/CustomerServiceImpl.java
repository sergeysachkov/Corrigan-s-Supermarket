package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;


public class CustomerServiceImpl implements CustomerService{
    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private CustomerDao customerDao;

    public CustomerServiceImpl() {
        customerDao = new CustomerDaoImpl();
    }

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public long addCustomer(Customer customer){
        return customerDao.addCustomer(customer);
    }

    public long updateCustomer(Customer customer){
        return customerDao.updateCustomer(customer);
    }
    public void deleteCustomer(long customerId){
        customerDao.deleteCustomer(customerId);
    }

    public Customer getCustomer(long customerId){
        return customerDao.getCustomer(customerId);
    }

    public void login(String user, String password){
        if(customerDao.checkCustomer(user, password)){
            throw new SecurityException("User name or Password incorrect ");
        }
    }

    public void addPaymentDetails(long customerId, PaymentDetails paymentDetails){
        try {
            if(paymentDetails.getCardNo() != null
                    && (paymentDetails.getCardNo().length() != 16 || !StringUtils.isNumeric(paymentDetails.getCardNo()))){
                throw new RuntimeException("Card Number should be 16 digits long and be numeric only");
            }

            if(paymentDetails.getCardNo() != null
                    && (paymentDetails.getCvv2().length() != 3 || !StringUtils.isNumeric(paymentDetails.getCardNo()))){
                throw new RuntimeException("CCV2 should be 3 digits long and be numeric only");
            }

            customerDao.addPaymentDetails(customerId, paymentDetails);
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Error occurred!", e);
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<PaymentDetails> getPaymentDetails(long customerId){
        return customerDao.getPaymentDetails(customerId);
    }

    public void deletePaymentDetails(long customerId, long paymentDetailsId){
        customerDao.deletePaymentDetails(customerId, paymentDetailsId);
    }
}
