package com.ait.corrigan.dao;

import com.ait.corrigan.models.shop.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public void addItem(Item item) throws SQLException {
        String sql="insert into Items "
                + "(itemID,name,stock_q,unit_of_measure,description,price,category) "
                + "values(?,?,?,?,?,?,?)";
        Connection con =DaoUtil.getConnection();
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setLong(1, item.getItemID());
        pst.setString(2, item.getName());
        pst.setInt(3, item.getStock_q());
        pst.setString(4, item.getUnit_of_measure());
        pst.setString(5, item.getDescription());
        pst.setDouble(6, item.getPrice());
        pst.setLong(7, item.getCateID());
        pst.executeUpdate();
        con.close();
    }

    @Override
    public void updateItem(Item item) throws SQLException {
        String sql="UPDATE Items SET "
                + "name=?,stock_q=?,unit_of_measure=?,description=?,price=?,category=? "
                + "WHERE itemID=?";
        Connection con=DaoUtil.getConnection();
        PreparedStatement pst=con.prepareCall(sql);
        pst.setString(  1, item.getName());
        pst.setInt(     2, item.getStock_q());
        pst.setString(  3, item.getUnit_of_measure());
        pst.setString(  4, item.getDescription());
        pst.setDouble(  5, item.getPrice());
        pst.setLong(    6, item.getCateID());
        pst.setLong(    7, item.getItemID());
        pst.executeUpdate();
        con.close();
        
    }

    @Override
    public void deleteItem(long itemId) throws SQLException {
        String sql="DELETE FROM Items WHERE  itemId=?";
        Connection con=DaoUtil.getConnection();
        PreparedStatement pst=con.prepareCall(sql);
        pst.setLong(1, itemId);
        pst.executeUpdate();
        con.close();
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> allItems = new ArrayList<>();
        Item item = null;
        Connection con;
        try {
            con = DaoUtil.getConnection();
            //String sql = "SELECT * FROM ITEMS";
            String sql = "SELECT Items.itemID, Items.name, Items.stock_q, Items.unit_of_measure, Items.description, Items.price, Categories.cate_name from Items left join Categories on Items.category=Categories.cateID;";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getDouble(6), rs.getString(7));
                allItems.add(item);
            }
            con.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return allItems;

    }

    // ========ADRIAN========
    @Override
    public List<Item> getItemsByCategory(String category) {

        List<Item> allItems = new ArrayList<Item>();
        Item item = null;
        Connection con;
        try {
            con = DaoUtil.getConnection();
            //String sql = "SELECT * FROM ITEMS";
            // String sql = "SELECT Items.itemID, Items.name, Items.stock_q, Items.unit_of_measure, Items.description, Items.price, Categories.cate_name from Items left join Categories on Items.category=Categories.cateID where Categories.cate_name=?";

            PreparedStatement pstmt = con.prepareStatement("SELECT Items.itemID, Items.name, Items.stock_q, Items.unit_of_measure, Items.description, Items.price, Categories.cate_name from Items left join Categories on Items.category=Categories.cateID where Categories.cate_name=?");
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                item = new Item(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
                        rs.getDouble(6), rs.getString(7));
                allItems.add(item);
            }
            con.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return allItems;

    }

    // ========ADRIAN========
    @Override
    public Item getItem(long itemId) {
        Item item = null;
        Connection con;
        try {
            con = DaoUtil.getConnection();

            String sql = "SELECT * FROM ITEMS WHERE itemID=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, itemId);
            ResultSet rs = pstmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            item = new Item(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
                    rs.getDouble(6), rs.getInt(7));
            con.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return item;
    }

}
