package com.ait.corrigan.beans;

import com.ait.corrigan.models.user.Customer;
import com.ait.corrigan.models.user.PaymentDetails;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Date;

/**
 * Created by root on 11/12/2016.
 */
@ManagedBean(name = "customer", eager = true)
@RequestScoped
public class CustomerBean {
    private Customer customer;
}
