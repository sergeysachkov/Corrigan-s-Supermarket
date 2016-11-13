package com.ait.corrigan.beans;

import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.CustomerService;
import com.ait.corrigan.services.CustomerServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Date;

/**
 * Created by root on 11/12/2016.
 */
@ManagedBean(name = "payment", eager = true)
@RequestScoped
public class PaymentBean {
    private PaymentDetails paymentDetails = new PaymentDetails();

    @ManagedProperty(value = "#{param.customerId}")
    private long customerId;

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
        CustomerService customerService = new CustomerServiceImpl();
        customerService.addPaymentDetails(customerId, paymentDetails);
        return "/home.xhtml?faces-redirect=true";
    }

    public String cancel(){
        return "/home.xhtml";
    }
}