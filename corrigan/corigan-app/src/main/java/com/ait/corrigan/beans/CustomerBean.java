package com.ait.corrigan.beans;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.CustomerService;
<<<<<<< HEAD
=======
import com.ait.corrigan.services.CustomerServiceImpl;
>>>>>>> refs/remotes/origin/master

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;

/**
 * Created by root on 11/12/2016.
 */
@ManagedBean(name = "customer", eager = true)
@RequestScoped
public class CustomerBean {
    private Customer customer;
    private String customerName;
    private String password; 
    public String getCustomerName(){
    return customerName;	
    	
    }
    public void setCustomerName(Customer customer) {
        this.customer = customer;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public  CustomerBean(){
    	
    }
    
  

    public long getCustomerId(){
        CustomerService customerService = new CustomerServiceImpl();
        List<Customer> customers = customerService.getCustomers();
        if(customers.isEmpty()){
            return 0;
        }
        return customers.get(0).getCustomerId();
}
}
