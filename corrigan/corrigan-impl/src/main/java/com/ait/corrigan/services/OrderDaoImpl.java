package com.ait.corrigan.services;

import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.dao.OrderDao;
import com.ait.corrigan.models.user.Order;

import java.sql.*;

/**
 * Created by root on 1/21/2017.
 */
public class OrderDaoImpl implements OrderDao {

    /**
     * Modified by Joshua<iyezi@hotmail.com> on 23 Feb 2017
     */
    @Override
    public long addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (orderid,customerid,price,status,time) "
                + "values (?,?,?,?,?)";

        try (Connection connection = DaoUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, order.getOrderId());
            stmt.setLong(2, order.getCustomerId());
            stmt.setDouble(3, order.getPrice());
            stmt.setString(4, order.getStatus());
            stmt.setTimestamp(5, order.getTime());
            stmt.executeUpdate();
            ResultSet r = stmt.getGeneratedKeys();
            if (r.next()) {
                return r.getLong(1);
            }
        }
        return 0;
    }

    /**
     * Created by Joshua<iyezi@hotmail.com> on 23 Feb 2017
     */
    @Override
    public Order getOrder(long orderId) throws SQLException {
        try (Connection connection = DaoUtil.getConnection();
                PreparedStatement stmt = connection.prepareStatement("select * from orders where orderid=?")) {
            stmt.setLong(1, orderId);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(orderId);
                order.setCustomerId(resultSet.getLong("customerid"));
                order.setPrice(resultSet.getDouble("price"));
                order.setStatus(resultSet.getString("status"));
                order.setTime(resultSet.getTimestamp("time"));
                return order;
            }
        }
        return null;
    }

    /**
     * Created by Joshua<iyezi@hotmail.com> on 23 Feb 2017
     */
    @Override
    public void updateOrder(Order order) throws SQLException {
        String sql = "update orders set "
                + "customerid=?,"
                + "price=?,"
                + "status=?,"
                + "time=?"
                + "where orderid=?";
        try (Connection con = DaoUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setLong(      1,  order.getCustomerId());
            pstmt.setDouble(    2,  order.getPrice());
            pstmt.setString(    3,  order.getStatus());
            pstmt.setTimestamp( 4,  order.getTime());
            pstmt.setLong(      5,  order.getOrderId());
            pstmt.executeUpdate();
            
        }
    }

    /**
     * Created by Joshua<iyezi@hotmail.com> on 23 Feb 2017
     */
    @Override
    public void deleteOrder(long orderId) throws SQLException {
        String sql="delete from orders where orderid=?";
        try(Connection con=DaoUtil.getConnection();
                PreparedStatement pstmt=con.prepareStatement(sql)){
            pstmt.setLong(1, orderId);
            pstmt.executeUpdate();
        }
    }

}
