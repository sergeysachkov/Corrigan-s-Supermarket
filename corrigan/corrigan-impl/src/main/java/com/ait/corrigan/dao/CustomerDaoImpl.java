package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Customer;

public class CustomerDaoImpl implements CustomerDao{

    public long addCustomer(Customer customer){return 0;}
    public long updateCustomer(Customer customer){return 0;}
    public void deleteCustomer(long customerId){}
    public Customer getCustomer(long customerId){
        return null;
    }

    public boolean checkCustomer(String user, String password){return false;}


}
