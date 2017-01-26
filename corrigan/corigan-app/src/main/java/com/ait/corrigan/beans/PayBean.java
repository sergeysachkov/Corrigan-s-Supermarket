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
import java.util.List;
import java.util.Set;

/**
 * Created by root on 1/21/2017.
 */
@ManagedBean(name = "pay", eager = true)
@RequestScoped
public class PayBean {
    private long customerId;
    @ManagedProperty(value = "#{param.basketId}")
    private long basketId;
    private Set<PaymentDetails> paymentDetails;

    private long payId;

    public List<PaymentDetails> getPaymentDetails() {
        PaymentService service = new PaymentServiceImpl();
        return service.getPaymentDetails(customerId);
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

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getBasketId() {
        return basketId;
    }

    public void setBasketId(long basketId) {
        this.basketId = basketId;
    }

    public String submit(){
        PayService service = new PayServiceImpl();
        long order = service.createOrderAndPay(new Order(0,customerId, basketId ));
        return "/home.xhtml?faces-redirect=true&orderId=" + order;
    }
    public String login() {
            return "/login.xhtml?faces-redirect=true&basketId=" + basketId;
    }
}
