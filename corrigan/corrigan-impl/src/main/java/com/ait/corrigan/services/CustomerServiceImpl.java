package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.models.user.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



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
}
