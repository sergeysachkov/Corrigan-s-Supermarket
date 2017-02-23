package com.ait.corrigan.dao;

import com.ait.corrigan.dao.DaoUtil;
import com.ait.corrigan.dao.OrderItemDao;
import com.ait.corrigan.models.user.OrderItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joshua<iyezi@hotmail.com>
 */
public class OrderItemDaoImpl implements OrderItemDao {
    
    
    
    private static final String addOISql="insert into orderitems "
            + "(orderid,itemid,quantity) values (?,?,?)";
    private static final String getOneOiSql="select * from orderitems where "
            + "orderid=? and itemid=?";
    private static final String getOisSql="SELECT * FROM orderitems WHERE "
            + "orderid=?";
    private static final String updateOISql="update orderitems set "
            + "quantity=? where orderid=? and itemid=?";
    private static final String delOISql="delete from orderitems where "
            + "orderid=? and itemid=?"; 
    private static final Logger LOG = Logger.getLogger(OrderItemDaoImpl.class.getName());
    
    
    @Override
    public void addOrderItem(OrderItem oi) throws SQLException {
        Connection con=DaoUtil.getConnection();
        PreparedStatement pstmt=con.prepareStatement(addOISql);
        pstmt.setLong(1,oi.getOrderId());
        pstmt.setLong(2,oi.getItemId());
        pstmt.setInt(3,oi.getQuantity());
        pstmt.executeUpdate();
        con.close();
    }

    @Override
    public OrderItem getOrderItem(long orderId, long itemId) throws SQLException {
        OrderItem oi=new OrderItem();
        Connection con=DaoUtil.getConnection();
        PreparedStatement pstmt=con.prepareStatement(getOneOiSql);
        pstmt.setLong(1, orderId);
        pstmt.setLong(2, itemId);
//        LOG.log(Level.INFO, pstmt.toString());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next())
        {
            oi.setOrderId(rs.getLong("orderid"));
            oi.setItemId(rs.getLong("itemid"));
            oi.setQuantity(rs.getInt("quantity"));
        }
        con.close();
        return oi;
    }
    
    @Override
    public List<OrderItem> getOrderItemsByOid(long orderId) throws SQLException {
        ArrayList<OrderItem> orderitems=new ArrayList<>();
        Connection con=DaoUtil.getConnection();
        PreparedStatement pstmt=con.prepareStatement(getOisSql);
        pstmt.setLong(1, orderId);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
            orderitems.add(new OrderItem(
                    rs.getLong("orderid"), 
                    rs.getLong("itemid"), 
                    rs.getInt("quantity")
            ));
        }
        con.close();
        return orderitems;
    }

    @Override
    public void deleteOrderItem(long orderId, long itemId) throws SQLException {
        Connection con=DaoUtil.getConnection();
        PreparedStatement pstmt=con.prepareStatement(delOISql);
        pstmt.setLong(1, orderId);
        pstmt.setLong(2, itemId);
        pstmt.executeUpdate();
        con.close();
        
    }

    @Override
    public void updateOrderItem(OrderItem oi) throws SQLException {
        Connection con=DaoUtil.getConnection();
        PreparedStatement pstmt=con.prepareStatement(updateOISql);
        pstmt.setInt(1,oi.getQuantity());
        pstmt.setLong(2,oi.getOrderId());
        pstmt.setLong(3, oi.getItemId());
        pstmt.executeUpdate();
        con.close();
    }
        
    public static void main(String[] args) throws SQLException {
        OrderItemDao oidao=new OrderItemDaoImpl();
//        oidao.addOrderItem(new OrderItem(1, 101, 5));
//        System.out.println("Order:"+oidao.getOrderItem(1,1));
//        System.out.println("Orders:"+oidao.getOrderItemsByOid(1));
//        oidao.deleteOrderItem(1, 101);
//        oidao.updateOrderItem(new OrderItem(1, 2, 19));
    }


    
}
