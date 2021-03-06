package com.ait.corrigan.beans;

import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.Address;
import com.ait.corrigan.services.AddressServiceImpl;
import com.ait.corrigan.services.AddressService;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.event.ComponentSystemEvent;

import java.util.Date;

/**
 * Created by root on 11/12/2016.
 */
@ManagedBean(name = "customer", eager = true)
@RequestScoped
public class CustomerBean {


    private boolean disabled = false;
    private boolean editable = false;

    private Customer customer1 = new Customer();

    public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}
	public Customer getCustomer1() {
		return customer1;
	}
    @ManagedProperty(value = "#{param.basketId}")
    private long basketId;
	private Address address = new Address();




    //------Peng-------
	//@ManagedProperty(value="#{param.customer1}")
    private String loginUsername;
    private String loginPassword;


    public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

    public String getCustomerSessionLogin(){
    	HttpSession session = SessionUtils.getSession();
		if (session != null)
			return (String) session.getAttribute("customerLogin");
    	return "guest";
    }
    public void setCustomerSessionLogin(String cutomerLogin){
    	this.loginUsername= cutomerLogin;
    }
    
    public long getIdCustomer(){
    	HttpSession session = SessionUtils.getSession();
		if (session != null)
			return (long) session.getAttribute("idCustomer");
    	return 0;
    }

    public  CustomerBean(){
    	
    }
    
    public String checkCustomer(){
    	System.out.println("username="+loginUsername);
    	boolean login = new CustomerDaoImpl().checkCustomer(loginUsername, loginPassword);
		if (login) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("customerLogin", loginUsername);
            session.setAttribute("idCustomer", new CustomerServiceImpl().getCustomerIdByLogin(loginUsername));
            if(basketId != 0){
                return "/pay.xhtml?faces-redirect=true&basketId=" + basketId;
            }else {
                return "/catalog.xhtml?faces-redirect=true";
            }
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect CustomerLogin and Passowrd",
							"Please enter correct CustomerLogin and Password"));
			return "/login.xhtml?faces-redirect=true";
		}
}

    //----------John-----------


	public boolean isEditable() {
		return editable;
	}

	public String editAction() {

		this.editable = true;
		return "/editCustomer.xhtml?id=" + id + "faces-redirect=true";
	}

	public String saveAction() {

		this.editable = false;

		return null;

	}

    public void setcustomerLogin(String customerLogin){
        customer1.setCustomerLogin(customerLogin);
}
        
    public String getcustomerLogin(){
    	if(customer1.getCustomerLogin() != null){
           return customer1.getCustomerLogin();
        }
            return "";
} 


    public void setLoginPassword(String loginPassword){
    	this.loginPassword = loginPassword;
    }
    
    public String getLoginPassword(){
    	return loginPassword;
    }

    @ManagedProperty(value = "#{param.customerId}")
    private long customerId;

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    
    public long getCustomerId(){
        return customer1.getCustomerId();
}

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    @ManagedProperty(value = "#{param.id}")
    private long id;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

        public boolean isDisabled() {
            return disabled;
        }


        public void setCustomerName(String name){
                customer1.setCustomerName(name);
        }
        
        public String getCustomerName(){
            return customer1.getCustomerName();
    }
        
        public void setcustomerSurname(String name){
            customer1.setCustomerSurname(name);
    }
        public String getcustomerSurname(){
            return customer1.getCustomerSurname();
    }
        public void setPassword(String password){
             customer1.setPassword(password);
    }
        public String getPassword(){
        	
        	//return  password;
        	if(customer1.getPassword() != null){
                return customer1.getPassword();
            }
           return "";
    }
        public void validatePassword(ComponentSystemEvent event) {

      	  FacesContext fc = FacesContext.getCurrentInstance();

      	  UIComponent components = event.getComponent();

      	  // get password
      	  UIInput uiInputPassword = (UIInput) components.findComponent("password");
      	  String password = uiInputPassword.getLocalValue() == null ? ""
      		: uiInputPassword.getLocalValue().toString();
      	  String passwordId = uiInputPassword.getClientId();

      	  // get confirm password
      	  UIInput uiInputConfirmPassword = (UIInput) components.findComponent("confirmPassword");
      	  String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
      		: uiInputConfirmPassword.getLocalValue().toString();

      	  // Let required="true" do its job.
      	  if (password.isEmpty() || confirmPassword.isEmpty()) {
      		return;
      	  }

      	  if (!password.equals(confirmPassword)) {

      		FacesMessage msg = new FacesMessage("Password must match confirm password");
      		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
      		fc.addMessage(passwordId, msg);
      		fc.renderResponse();

      	  }

      	}
        
        public void setphoneNumber(String phonenumber){
            customer1.setPhoneNumber(phonenumber);
    }
        
        public String getphoneNumber(){
        	if(customer1.getPhoneNumber() != null){
                return customer1.getPhoneNumber();
            }
            return "";
    }
        
        
        public void setAdressLine1(String adressLine1){
            address.setAdressLine1(adressLine1);
    }
        
        public String getAdressLine1(){
        	if(address.getAdressLine1() != null){
                return address.getAdressLine1();
            }
            return "";

    }
        public void setAdressLine2(String adressLine2){
            address.setAdressLine2(adressLine2);
    }
        
        public String getAdressLine2(){
            return address.getAdressLine2();
    }
        public void setTown(String town){
            address.setTown(town);
    }
        
        public String getTown(){
            return address.getTown();
    }
        public void setCounty(String county){
            address.setCounty(county);
    }
        
        public String getCounty(){
            return address.getCounty();
    }
        public void setEircode(String eircode){
            address.setEircode(eircode);
    }
    
        public String getEircode(){
            return address.getEircode();
    }
        
        public void setCustomerDateOfBirth(Date CustomerDateOfBirth){
            customer1.setCustomerDateOfBirth(CustomerDateOfBirth);
    }
    
        public Date getCustomerDateOfBirth(){
            return customer1.getCustomerDateOfBirth();
    }
        public void setEmail(String email){
            customer1.setEmail(email);
    }
    
        public String getEmail(){
            return customer1.getEmail();
    }
        public String submit(){
            CustomerService customerService = new CustomerServiceImpl();
            AddressService addressService = new AddressServiceImpl();
            long id  = customerService.addCustomer(customer1);
            long id1 = addressService.addAddress(address);
            return "/catalog.xhtml?id=" + id + "faces-redirect=true";
        }

        public String update(){
            CustomerService customerService = new CustomerServiceImpl();
            AddressService addressService = new AddressServiceImpl();
            long cus1 = getIdCustomer();
            customerService.updateCustomer(cus1, customer1);
            addressService.updateAddress(cus1, address);
            return "/catalog.xhtml?id=" + id + "faces-redirect=true";
        }


        public String cancel(){
            this.disabled =false;
            this.customer1 = new Customer();
            return "/catalog.xhtml?faces-redirect=true";
        }


        public String getCustomer11(){
        	if(loginUsername != ""){
	        	this.customer1 = new Customer();
	        	this.address = new Address();
	        	CustomerService custServ = new CustomerServiceImpl();
	        	Customer cus = new Customer();
	        	long cus1 = getIdCustomer();
	        	cus = custServ.getCustomerByID(cus1);
	        	customer1 = cus;
	        	AddressService adServ = new AddressServiceImpl();
	        	Address Ad = new Address();
	        	Ad = adServ.getAddress(cus1);
	        	address = Ad;
	        	return "Y";
        	}
        	else{ return "/AddCustomer.xhtml?faces-redirect=true";}

        }
}
