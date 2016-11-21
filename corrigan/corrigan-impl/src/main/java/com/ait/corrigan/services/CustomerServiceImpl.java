package com.ait.corrigan.services;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Customer;
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
    public void login(String customerLogin, String password){
        if(CustomerDao.checkCustomer(customerLogin, password)){
            throw new SecurityException("User name or Password incorrect ");
        }
    }

	
}
