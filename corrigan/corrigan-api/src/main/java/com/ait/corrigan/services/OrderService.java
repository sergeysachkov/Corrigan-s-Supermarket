package com.ait.corrigan.services;

import com.ait.corrigan.models.user.Order;

/**
 *
 * @author Joshua<iyezi@hotmail.com>
 * Created on 23 Feb 2017
 */
public interface OrderService {
    public long addOrder(Order order);
    public Order getOrder(long orderId);
    public void updateOrder(Order order);
    public void deleteOrder(long orderId);
    public void setOrderStatus(long orderId, String orderStatus);
}
