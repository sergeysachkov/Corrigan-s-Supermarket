package com.ait.corrigan.beans;

import com.ait.corrigan.models.user.Order;
import com.ait.corrigan.models.user.PaymentDetails;
import com.ait.corrigan.services.PayService;
import com.ait.corrigan.services.PayServiceImpl;
import com.ait.corrigan.services.PaymentService;
import com.ait.corrigan.services.PaymentServiceImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by root on 1/21/2017.
 */
@ManagedBean(name = "pay", eager = true)
@RequestScoped
public class PayBean {
    @ManagedProperty(value = "#{param.basketId}")
    private long basketId;

    @ManagedProperty(value = "#{basketBean}")
    private BasketBean basketBean;

    private Set<PaymentDetails> paymentDetails;

    private long payId;

    public List<String> getPaymentDetails() {
        long customerId = getCustomerId();
        if(customerId == 0){
            return new ArrayList<>();
        }
        PaymentService service = new PaymentServiceImpl();
        return service.getPaymentCards(customerId);
    }


    public BasketBean getBasketBean() {
        return basketBean;
    }

    public void setBasketBean(BasketBean basketBean) {
        this.basketBean = basketBean;
    }

    public long getCustomerId() {
        return SessionUtils.getCustomerId();
    }

    public long getPayId() {
        return payId;
    }

    public void setPayId(long payId) {
        this.payId = payId;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public String submit(){
        PayService service = new PayServiceImpl();
        long order = service.createOrderAndPay(new Order(0,getCustomerId(), basketId ));
        return "/home.xhtml?faces-redirect=true&orderId=" + order;
    }

    public String addCard(){
        return "/payment.xhtml?faces-redirect=true&customerId=" + getCustomerId() + "&basketId=" + basketId;
    }
    public String login() {
            return "/login.xhtml?faces-redirect=true&basketId=" + basketId;
    }
}
