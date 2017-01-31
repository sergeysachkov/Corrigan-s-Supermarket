package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Order;

/**
 * Created by root on 1/21/2017.
 */
public interface PayService {
    public long createOrderAndPay(Order order);
}
