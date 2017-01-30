package com.ait.corrigan.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.Manager;
import com.ait.corrigan.services.AddressService;
import com.ait.corrigan.services.AddressServiceImpl;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;
import com.ait.corrigan.services.ManagerService;
import com.ait.corrigan.services.ManagerServiceImpl;


@ManagedBean(name = "manager", eager = true)
@RequestScoped
public class ManagerBean {

	private Manager manager = new Manager();
	
	   public void setManagerLogin(String managerLogin){
	        manager.setManagerLogin(managerLogin);
	}
	        
	    public String getManagerLogin(){
	    	if(manager.getManagerLogin() != null){
	           return manager.getManagerLogin();
	        }
	            return "";
	} 

		   public void setManagerPassword(String managerPassword){
		        manager.setManagerPassword(managerPassword);
		}
		        
		    public String getManagerPassword(){
		    	if(manager.getManagerPassword() != null){
		           return manager.getManagerPassword();
		        }
		            return "";
		} 
	  


	    public void setManagerID(long managerID) {
	        manager.setManagerID(managerID);;
	    }
	    
	    public long getManagerID(){
	        return manager.getManagerID();
	}

	        public void setManagerName(String name){
	                manager.setManagerName(name);
	        }
	        
	        public String getManagerName(){
	            return manager.getManagerName();
	    }
	        
	        public void setManagerSurname(String managerSurname){
	            manager.setManagerSurname(managerSurname);
	    }
	        public String getManagerSurname(){
	             return manager.getManagerSurname();
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
	        
	        public String submit(){
	            ManagerService managerService = new ManagerServiceImpl();
	            long id  = managerService.addManager(manager);
	            return "/AddManager.xhtml?id=faces-redirect=true";
	        }
	        
	        public String cancel(){
	            this.manager = new Manager();
	            return "/home.xhtml?faces-redirect=true";
	        }
}
