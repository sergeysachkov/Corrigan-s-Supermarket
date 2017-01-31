package com.ait.corrigan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ait.corrigan.models.shop.Category;
import java.sql.Statement;

public class CategoryDAOImpl implements CategoryDao {

    @Override
    public long getNewId() throws SQLException {
        String sql = "SELECT cateID FROM Categories ORDER BY cateID DESC LIMIT 1";
        Connection con = DaoUtil.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if (rs.next()) {
            long id = rs.getLong(1);
            con.close();
            return ++id;
        } else {
            con.close();
            return 1;
        }
    }

    @Override
    public List<Category> getAllCategories() throws SQLException {

        List<Category> allCategories = new ArrayList<Category>();
        Category cat = null;
        Connection con = null;
        try {
            con = DaoUtil.getConnection();
            String sql = "select cate_name from Categories";

            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cat = new Category(rs.getString(1));
                allCategories.add(cat);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            con.close();
        }
        return allCategories;

    }

    @Override
    public void addCategory(long id, String name) throws SQLException {
        String sql = "INSERT INTO Categories (cateID, cate_name) VALUES (?,?)";
        Connection con = DaoUtil.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1, id);
        pst.setString(2, name);
        pst.executeUpdate();
        con.close();
    }

    @Override
    public void deleteCategory(int categoryId) throws SQLException {
    	String sql = "DELETE FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
    	 Connection con = DaoUtil.getConnection();
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setLong(1, categoryId);       
         pst.executeUpdate();
         con.close();
    }

    @Override
    public void updateCategory(long id, String name) throws SQLException {
    	String sql = "UPDATE FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
    	 Connection con = DaoUtil.getConnection();
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setLong(1, id);
         pst.setString(2, name);
         pst.executeUpdate();
         con.close();
    	//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category getCategory(int categoryId) throws SQLException {
    	
    	Category category = null;
    	String sql = "SELECT FROM Categories (cateID, cate_name) VALUES (?,?) Where (cateID= ?)";
   	    Connection con = DaoUtil.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1, categoryId);
     
        pst.executeUpdate();
        con.close();
        return category;
    	
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
