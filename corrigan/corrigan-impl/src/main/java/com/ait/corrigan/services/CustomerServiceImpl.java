package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Customer;

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

    public CustomerServiceImpl(long customerID, CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public long addCustomer(long customerID, Customer customer){
    	try{
    		if(customer.getPhoneNumber() != null
                 && (customer.getCustomerSurname() != null)) {
             throw new CorriganException("Card Number should be 16 digits long and be numeric only");}
        return customerDao.addCustomer(customerID, customer);

        } catch (SQLException e) {
            logger.error("Error occurred!", e);
            throw new CorriganException(e.getMessage());
        }
    
    }

    public long updateCustomer(Customer customer){
        return customerDao.updateCustomer(customer);
    }
    public void deleteCustomer(long customerId){
        customerDao.deleteCustomer(customerId);
    }

    public Customer getCustomer(long customerId){
        try {
            return customerDao.getCustomer(customerId);
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }

    public List<Customer> getCustomers(){
        try {
            return customerDao.getCustomers();
        } catch (SQLException e) {
            throw new CorriganException(e.getMessage());
        }
    }
    public void login(String user, String password){
        if(customerDao.checkCustomer(user, password)){
            throw new SecurityException("User name or Password incorrect ");
        }
    }
}
