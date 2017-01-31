package com.ait.corrigan.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by root on 1/21/2017.
 */
@ManagedBean
@RequestScoped
public class NavigationBean {
    private long customerId;
    private long basketId;

    public long getCustomerId() {
        return customerId;
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

    public String toLogin() {
        if(basketId != 0){
            return "/login.xhtml?baksetId=" + basketId;
        }else {
            return "/login.xhtml";
        }
    }
}
