package com.ait.corrigan.services;

import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.dao.OrderDao;
import com.ait.corrigan.models.user.Order;

import java.sql.*;

/**
 * Created by root on 1/21/2017.
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public long addOrder(Order order) throws SQLException {
        try(Connection connection = DaoUtil.getConnection();

        PreparedStatement stmt=connection.prepareStatement("INSERT INTO orders (customerid, price, status, time ) " +
                    "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, order.getUserId());
            stmt.setDouble(2, order.getPrice());
            stmt.setString(3, order.getStatus());
            stmt.setTimestamp(4, order.getTime());
            stmt.executeUpdate();
            ResultSet r = stmt.getGeneratedKeys();
            if(r.next()){
                return r.getLong(1);
            }

        }
        return 0;
    }

    @Override
    public long updateBasket(long basketIdOld, long itemIdOld, Order order) throws SQLException {
        return 0;
    }

    @Override
    public long deleteBasket(long orderId) throws SQLException {
        return 0;
    }

    @Override
    public Order getOrder(long orderId) throws SQLException {
        try(Connection connection = DaoUtil.getConnection();
            PreparedStatement stmt=connection.prepareStatement("select * from order where orderID=?")) {
            stmt.setLong(1, orderId);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()){
                Order order = new Order();
                order.setOrderId(orderId);
                order.setUserId(resultSet.getInt("userID"));
                order.setBasketId(resultSet.getLong("basketID"));
                return order;
            }
        }
        return null;
    }
}
