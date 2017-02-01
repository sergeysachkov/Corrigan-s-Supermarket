package com.ait.corrigan.beans;

import com.ait.corrigan.models.user.Address;
import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.AddressService;
import com.ait.corrigan.services.AddressServiceImpl;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;
import com.ait.corrigan.services.PaymentService;
import com.ait.corrigan.services.PaymentServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import java.util.Date;

/**
 * Created by root on 11/12/2016.
 */
@ManagedBean(name = "payment", eager = true)
@RequestScoped
public class PaymentBean {
    private PaymentDetails paymentDetails = new PaymentDetails();
    private boolean editable = false;

    public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
    
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}



	@ManagedProperty(value = "#{param.customerId}")
    private long customerId;

    @ManagedProperty(value = "#{param.id}")
    private long id;

    @ManagedProperty(value = "#{param.basketId}")
    private long basketId;

    private boolean disabled = false;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        if(id != 0){
            PaymentService paymentService = new PaymentServiceImpl();
            this.paymentDetails = paymentService.getPaymentDetail(this.id);
            this.disabled = true;
        }
    }

    public boolean isDisabled() {
        return disabled;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public PaymentDetails.CardType getType(){
       if(paymentDetails.getType() != null){
           return paymentDetails.getType();
       }
       return PaymentDetails.CardType.MASTERCARD;
    }

    public void setType(PaymentDetails.CardType type){
            paymentDetails.setType(type);
    }

    public PaymentDetails.CardType [] getTypes(){
        return paymentDetails.getTypes();
    }

    public String getCardNo(){
        if(paymentDetails.getCardNo() != null){
            return paymentDetails.getCardNo();
        }
        return "";
    }
    public String getCvv2(){

        if(paymentDetails.getCvv2() != null){
            return paymentDetails.getCvv2();
        }
        return "";
    }
    public String getCardHolder(){

        if(paymentDetails.getCardHolder() != null){
            return paymentDetails.getCardHolder();
        }
        return "";
    }
    public Date getDate(){
        if(paymentDetails.getExpireDate() != null){
            return paymentDetails.getExpireDate();
        }
        return new Date();
    }

    public void setCardNo(String cardNo){
        paymentDetails.setCardNo(cardNo);
    }
    public void setCvv2(String ccv2){
        paymentDetails.setCvv2(ccv2);
    }
    public void setCardHolder(String holder){
        paymentDetails.setCardHolder(holder);
    }
    public void setDate(Date date){
        paymentDetails.setExpireDate(date);
    }

    public String submit(){
        PaymentService paymentService = new PaymentServiceImpl();
        long cus1 = getIdCustomer();
        long id  = paymentService.addPaymentDetails(cus1, paymentDetails);
        if(basketId != 0){
            return "/payment.xhtml?id=" + id + "&faces-redirect=true&basketId=" + basketId;
        }else {
            return "/pay.xhtml?id=" + id + "&faces-redirect=true";
        }
    }
    
    public String update(){
        PaymentService paymentService = new PaymentServiceImpl();
    	long cus1 = getIdCustomer();
        long id  = paymentService.updatePaymentDetails(cus1, paymentDetails);
        if(basketId != 0){
            return "/payment.xhtml?id=" + id + "&faces-redirect=true&basketId=";
        }else {
            return "/home.xhtml?id=" + id + "&faces-redirect=true";
        }
    }

    public String cancel(){
        this.disabled =false;
        this.paymentDetails = new PaymentDetails();
        this.id = 0;
        return "/home.xhtml?faces-redirect=true";
    }
    

    
    public void getCustomerPaymentDetails(){
    	PaymentService payServ = new PaymentServiceImpl();
    	PaymentDetails pay = new PaymentDetails();
    	CustomerBean bean = new CustomerBean();
    	long cus1 = bean.getIdCustomer();
    	pay = payServ.getPaymentDetail(cus1);
    	paymentDetails = pay;
    }
    
	public boolean isEditable() {
		return editable;
	}

	public String editAction() {

		this.editable = true;
		return "/updateCard.xhtml?id=" + id + "faces-redirect=true";
	}
	
    public long getIdCustomer(){
    	HttpSession session = SessionUtils.getSession();
		if (session != null)
			return (long) session.getAttribute("idCustomer");
    	return 1;
    }
}
