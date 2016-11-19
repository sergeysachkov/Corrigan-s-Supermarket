package com.ait.corrigan.beans;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Date;

/**
 * Created by root on 11/12/2016.
 */
@ManagedBean(name = "customer", eager = true)
@RequestScoped
public class CustomerBean {
    private Customer customer;
    @ManagedProperty(value = "#{param.customerId}")
    private long customerId;

    public long getCustomerId() {
        return customerId;
    }

   
    public String getCustomerName() {
       if(Customer.getCustomerName() != null){
    	   return Customer.getCustomerName();
       }
       return "";
       }
   
    public String getCustomerSurname() {
    	if(Customer.getCustomerSurname() != null){
     	   return Customer.getCustomerSurname();
        }
        return "";
    }

    public String getCustomerLogin() {
    	if(Customer.getCustomerLogin() != null){
      	   return Customer.getCustomerLogin();
         }
         return "";
    }
    public String getPassword() {
    	if(Customer.getPassword() != null){
       	   return Customer.getPassword();
          }
          return "";
    }
    public String getPhoneNumber() {
    	if(Customer.getPhoneNumber() != null){
        	   return Customer.getPhoneNumber();
           }
           return "";
    }
    public String getEmail() {
    	if(Customer.getEmail() != null){
     	   return Customer.getEmail();
        }
        return "";
    }
    public Date getCustomerDateOfBirth() {
    	if(Customer.getCustomerDateOfBirth() != null){
      	   return Customer.getCustomerDateOfBirth();
         }
    	return new Date();
    }

    public long getAddressId() {
    	if(Customer.getAddressId() != null){
       	   return Customer.getAddressId();
          }
          return "";
    }
    
    public void setCustomerId(long customerId) {
        Customer.setCustomerId(customerId);
    }
    
    
    public void setCustomerName(String customerName) {
    	Customer.setCustomerName(customerName);
    }
    public void setCustomerSurname(String customerSurname) {
    	Customer.setCustomerSurName(customersurName);
    
    }
    
    public void setCustomerLogin(String customerLogin) {
    	Customer.setCustomerLogin(customerLogin);
    }
   
    public void setPassword(String password) {
    	Customer.setPassword(password);
    }
    public void setPhoneNumber(String phoneNumber) {
    	Customer.setPhoneNumber(phoneNumber);
    }
    public void setEmail(String email) {
    	Customer.setEmail(email);
    }
    
    public void setCustomerDateOfBirth(Date customerDateOfBirth) {
    	Customer.setCustomerDateOfBirth(customerDateOfBirth);
    }
    
    public void setAdressId(long addressId) {
    	Customer.setAdressId(addressId);
    }
    
}
