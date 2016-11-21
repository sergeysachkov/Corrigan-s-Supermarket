package com.ait.corrigan.beans;

import com.ait.corrigan.dao.CustomerDao;
import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
    private String customerLogin;
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
    public String getCustomerLogin(){
    	return customerLogin;
    }
    public void setCustomerLogin(String cutomerLogin){
    	this.customerLogin= cutomerLogin;
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
    public String checkCustomer(){
    	boolean login = CustomerDaoImpl.checkCustomer(customerLogin, password);
		if (login) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("customerLogin", customer);
			return "/home.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect CustomerLogin and Passowrd",
							"Please enter correct CustomerLogin and Password"));
			return "/login.xhtml?faces-redirect=true";
		}   
}
}
