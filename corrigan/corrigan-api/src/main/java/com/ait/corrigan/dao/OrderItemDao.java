package com.ait.corrigan.dao;

import com.ait.corrigan.models.user.OrderItem;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Joshua<iyezi@hotmail.com>
 */
public interface OrderItemDao {
    void addOrderItem(OrderItem oi) throws SQLException;
    OrderItem getOrderItem(long orderId, long itemId) throws SQLException;
    List<OrderItem> getOrderItemsByOid(long orderId) throws SQLException;
    void updateOrderItem(OrderItem oi) throws SQLException;
    void deleteOrderItem(long orderId, long itemId) throws SQLException;
}
