package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ait.corrigan.models.user.Basket;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Database operations on shopping baskets. Note that a basket object contains
 * only one item instead a whole actual basket.
 *
 * @author Joshua <iyezi@hotmail.com>
 */
public class BasketDaoImpl implements BasketDao {

    private Connection con = null;
    private static final Logger LOG = Logger.getLogger(BasketDaoImpl.class.getName());

    public BasketDaoImpl() {
        try {
            con = DaoUtil.getConnection();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "DB connection fail.", ex);
        }
    }

    @Override
    public void addBasket(Basket basket) throws SQLException {
        String sql = "INSERT INTO basket (basketID,userID,itemID,quantity) VALUES (?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, basket.getBasketId());
        pstmt.setLong(2, basket.getUserId());
        pstmt.setLong(3, basket.getItemId());
        pstmt.setInt(4, basket.getQuantity());
        pstmt.executeUpdate();
    }

    @Override
    public void updateBasket(Basket basket) throws SQLException {
        String sql = "UPDATE basket SET userID=?, itemID=?, quantity=? WHERE (basketID=? and itemID=?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, basket.getUserId());
        pstmt.setLong(2, basket.getItemId());
        pstmt.setInt(3, basket.getQuantity());
        pstmt.setLong(4, basket.getBasketId());
        pstmt.setLong(5, basket.getItemId());
        pstmt.executeUpdate();
    }

    @Override
    public void deleteBasket(long basketId, long itemId) throws SQLException {
        String sql = "DELETE FROM basket WHERE (baksetID=? and itemID=?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, basketId);
        pstmt.setLong(2, itemId);
        pstmt.executeUpdate();
    }

    @Override
    public Basket getBasket(long basketId, long itemId) throws SQLException {
        Basket basketResult = new Basket();
        String sql = "SELECT * FROM basket WHERE (basketID=? and itemID?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setLong(1, basketId);
        pstmt.setLong(2, itemId);
        ResultSet rs = pstmt.executeQuery();
        if (!rs.next()) {
            basketResult.setBasketId(basketId);
            basketResult.setItemId(itemId);
            basketResult.setUserId(rs.getLong("userID"));
            basketResult.setQuantity(rs.getInt("quantity"));
        }
        return basketResult;
    }

    @Override
    public List<Basket> getCompleteBasket(long basketId) throws SQLException {
        List<Basket> completeBasket=new ArrayList<>();
        String sql="SELECT * FROM basket WHERE (basketID=?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setLong(1, basketId);
        ResultSet rs=pstmt.executeQuery();
        while(!rs.next()){
            long userId=rs.getLong("userID");
            long itemId=rs.getLong("itemID");
            int quantity=rs.getInt("quantity");
            completeBasket.add(new Basket(basketId, userId, itemId, quantity));
        }
        return completeBasket;
    }

    @Override
    public void deleteOneCompleteBasket(long basketId) throws SQLException {
        String sql="DELETE FROM basket WHERE (basketID=?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setLong(1, basketId);
        pstmt.executeUpdate();
    }
}
