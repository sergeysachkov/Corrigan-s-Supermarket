/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ait.corrigan.services;

import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.dao.OrderDao;
import com.ait.corrigan.dao.OrderDaoImpl;
import com.ait.corrigan.dao.OrderItemDao;
import com.ait.corrigan.dao.OrderItemDaoImpl;
import com.ait.corrigan.exception.CorriganException;
import com.ait.corrigan.models.user.Order;
import com.ait.corrigan.models.user.OrderItem;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Joshua<iyezi@hotmail.com>
 */
public class OrderServiceImpl implements OrderService {
    
    private OrderDao odao;
    private OrderItemDao oidao;

    public OrderServiceImpl() {
        odao = new OrderDaoImpl();
        oidao = new OrderItemDaoImpl();
    }

    @Override
    public long addOrder(Order order) {
        if (order.getOrderId() == 0) {
            order.setOrderId(DaoUtil.getUniqueId());
        }
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrderId(order.getOrderId());
        }
        try {
            odao.addOrder(order);
            for (OrderItem oi : order.getOrderItems()) {
                oidao.addOrderItem(oi);
            }
        } catch (SQLException ex) {
            throw new CorriganException(ex.getMessage(), ex);
        }
        return order.getOrderId();
    }
    
    @Override
    public Order getOrder(long orderId) {
        Order order = null;
        try {
            order = odao.getOrder(orderId);
            order.setOrderItems(oidao.getOrderItemsByOid(orderId));
        } catch (SQLException | NullPointerException ex) {
            throw new CorriganException("Error getting order", ex);
        }
        return order;
    }
    public void setOrderStatus(long orderId, String orderStatus){
        Order order;
        try{
            order=odao.getOrder(orderId);
            order.setStatus(orderStatus);
            odao.updateOrder(order);
        }catch(SQLException ex){
            throw new CorriganException(ex.getMessage());
        }
    }
    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void deleteOrder(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /////////
    
//    public static void main(String[] args) {
//        OrderService osrv = new OrderServiceImpl();
//        System.out.println(osrv.getOrder(1));
//        List<OrderItem> ois=new ArrayList<>();
//        ois.add(new OrderItem(0, 1, 1));
//        ois.add(new OrderItem(0, 2, 1));
//        ois.add(new OrderItem(0, 3, 3));
//        Order o1 = new Order(0, 1, 1, "Pending", new Timestamp(System.currentTimeMillis()),ois);
//        osrv.addOrder(o1);
//    }
}
