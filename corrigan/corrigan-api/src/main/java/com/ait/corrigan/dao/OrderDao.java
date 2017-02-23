package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.Order;

import java.sql.SQLException;

/**
 * Created by root on 1/21/2017.
 */
public interface OrderDao {
    long addOrder(Order order) throws SQLException;
    Order getOrder(long orderId) throws SQLException;
    void updateOrder(Order order) throws SQLException;
    void deleteOrder(long orderId) throws SQLException;
}
