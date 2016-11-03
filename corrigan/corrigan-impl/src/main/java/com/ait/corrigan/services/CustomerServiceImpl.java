package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

public class CustomerServiceImpl implements CustomerService{
    CustomerDao customerDao = new CustomerDaoImpl();

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
        customerDao.addPaymentDetails(customerId, paymentDetails);
    }
    public void updatePaymentDetails(long customerId, PaymentDetails paymentDetails){
        customerDao.updatePaymentDetails(customerId, paymentDetails);
    }
    public void deletePaymentDetails(long customerId, long paymentDetailsId){
        customerDao.deletePaymentDetails(customerId, paymentDetailsId);
    }
}
