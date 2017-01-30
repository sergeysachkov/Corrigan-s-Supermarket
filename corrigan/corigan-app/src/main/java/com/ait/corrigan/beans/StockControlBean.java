package com.ait.corrigan.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.ait.corrigan.dao.CustomerDaoImpl;
import com.ait.corrigan.dao.StockControlDaoImpl;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.StockControl;

@ManagedBean(name = "stockControl", eager = true)
@RequestScoped

public class StockControlBean {
	private boolean disabled = false;
    private boolean editable = false;
    private StockControl stockControl = new StockControl();
    private String username;
    private String password;
   
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	@ManagedProperty(value = "#{param.stockCID}")
    private long stockCID;
	public long getStockCID() {
		return stockCID;
	}
	public void setStockCID(long stockCID) {
		this.stockCID = stockCID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public String getStockControlLogin(){
	    	HttpSession session = SessionUtils.getSession();
			if (session != null)
				return (String) session.getAttribute("StockControlLogin");
	    	return "guest";
	    }
	    public void setStockControlLogin(String stockControlLogin){
	    	this.username= stockControlLogin;
	    }
    public StockControlBean(){
    	
    }
    public String checkStockControl(){
    	System.out.println("username="+username);
    	boolean SClogin = StockControlDaoImpl.checkStockControl(username, password);
		if (SClogin) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("StockControlLogin", username);
			return "/home.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect StockControlLogin and Passowrd",
							"Please enter correct StockControlLogin and Password"));
			return "/stockControllogin.xhtml?faces-redirect=true";
		}   
}
    
  
}
