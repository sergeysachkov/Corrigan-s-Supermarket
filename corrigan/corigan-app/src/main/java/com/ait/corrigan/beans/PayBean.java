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
import java.sql.Timestamp;
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
    private String cardNo;

    private long payId;

    public List<String> getPaymentDetails() {
        long customerId = getCustomerId();
        if(customerId == 0){
            return new ArrayList<>();
        }
        PaymentService service = new PaymentServiceImpl();
        return service.getPaymentCards(customerId);
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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

    /**
     * @author joshua<iyezi@hotmail.com>
     * @return the total price for the shopping basket
     */
    public double getPrice(){
        return basketBean.getTotal();
    }
    public String submit(){
        PayService service = new PayServiceImpl();
        Order order=new Order(0, getCustomerId(), basketBean.getTotal(), 
                "Pending", new Timestamp(System.currentTimeMillis()));
        order.setOrderItemsFromBasket(basketBean.getBasketItems());
        basketBean.clearBasket();
        long orderId = service.createOrderAndPay(cardNo, order);
        return "/home.xhtml?faces-redirect=true&orderId=" + orderId;
    }

    public String addCard(){
        return "/payment.xhtml?faces-redirect=true&customerId=" + getCustomerId() + "&basketId=" + basketId;
    }
    public String login() {
            return "/login.xhtml?faces-redirect=true&basketId=" + basketId;
    }
}
